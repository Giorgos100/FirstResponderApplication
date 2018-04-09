package giorgos.FirstResponderApplication.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import giorgos.FirstResponderApplication.R;
import giorgos.FirstResponderApplication.LocalDatabase.DatabaseHelper;
import giorgos.FirstResponderApplication.LocalDatabase.InputValidation;
import giorgos.FirstResponderApplication.LocalDatabase.User;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout InputLayoutFirstName;
    private TextInputLayout InputLayoutLastName;
    private TextInputLayout InputLayoutBirthday;
    private TextInputLayout InputLayoutEmail;
    private TextInputLayout InputLayoutPassword;
    private TextInputLayout InputLayoutConfirmPassword;



    private TextInputEditText InputFirstName;
    private TextInputEditText InputLastName;
    private EditText          InputBirthday;
    private TextInputEditText InputEmail;
    private TextInputEditText InputPassword;
    private TextInputEditText InputConfirmPassword;


    private DatePickerDialog datePickerDialog;
    private AppCompatButton appCompatButtonRegister;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        //Set listeners of views
        //setViewActions();
        //Create DatePickerDialog to show a calendar to user to select birthdate
        prepareDatePickerDialog();
        initViews();
        initListeners();
        initObjects();
    }

    private void setViewActions() { InputBirthday.setOnClickListener(this); }

    private void prepareDatePickerDialog() {
        //Get current date
        Calendar calendar=Calendar.getInstance();

        //Create datePickerDialog with initial date which is current and decide what happens when a date is selected.
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change birthdayEdittext's text and dismiss dialog.
                InputBirthday.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                datePickerDialog.dismiss();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        InputLayoutFirstName         = (TextInputLayout) findViewById(R.id.InputLayoutFirstName);
        InputLayoutLastName          = (TextInputLayout) findViewById(R.id.InputLayoutLastName);
        InputLayoutEmail             = (TextInputLayout) findViewById(R.id.InputLayoutEmail);
        InputLayoutPassword          = (TextInputLayout) findViewById(R.id.InputLayoutPassword);
        InputLayoutBirthday          = (TextInputLayout) findViewById(R.id.InputLayoutBirthday);
        InputLayoutConfirmPassword   = (TextInputLayout) findViewById(R.id.InputLayoutConfirmPassword);



        InputFirstName = (TextInputEditText) findViewById(R.id.InputFirstName);
        InputLastName = (TextInputEditText) findViewById(R.id.InputLastName);
        InputBirthday = (EditText) findViewById(R.id.InputBirthday);
        InputEmail = (TextInputEditText) findViewById(R.id.InputEmail);
        InputPassword = (TextInputEditText) findViewById(R.id.InputPassword);
        InputConfirmPassword = (TextInputEditText) findViewById(R.id.InputConfirmPassword);


        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.ButtonRegister);



    }

    public void goToLoginActivity()
    {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }

    private void initListeners()
    { appCompatButtonRegister.setOnClickListener(this);
        InputBirthday.setOnClickListener(this);
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }







    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(InputFirstName,InputLayoutFirstName, getString(R.string.error_message_name)))
        {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(InputLastName,InputLayoutLastName, getString(R.string.error_message_name)))
        {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(InputEmail, InputLayoutEmail, getString(R.string.error_message_email)))
        {
            return;
        }

        if (!inputValidation.isInputEditTextEmail(InputEmail, InputLayoutEmail, getString(R.string.error_message_email)))
        {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(InputPassword, InputLayoutPassword, getString(R.string.error_message_password)))
        {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(InputPassword, InputConfirmPassword, InputLayoutConfirmPassword, getString(R.string.error_password_match)))
        {
            return;
        }

        if (!databaseHelper.checkUser(InputEmail.getText().toString().trim())) {

            user.setFirstName(InputFirstName.getText().toString().trim());
            user.setLastName(InputLastName.getText().toString().trim());
            user.setBirthday(InputBirthday.getText().toString().trim());
            user.setEmail(InputEmail.getText().toString().trim());
            user.setPassword(InputPassword.getText().toString().trim());


            databaseHelper.addUser(user);


            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            goToLoginActivity();



        }
    }



    //empty inputs
    private void emptyInputEditText() {
        InputFirstName.setText(null);
        InputLastName.setText(null);
        InputBirthday.setText(null);
        InputEmail.setText(null);
        InputPassword.setText(null);
        InputConfirmPassword.setText(null);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.InputBirthday:
                datePickerDialog.show();
                break;
            case R.id.ButtonRegister:
                postDataToSQLite();
                break;

        }
    }

}
