package giorgos.FirstResponderApplication.Activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import giorgos.FirstResponderApplication.R;


public class CrisisCategoriesActivity extends AppCompatActivity {
    ImageButton FireCategory;
    ImageButton MedicalCategory;
    ImageButton AccidentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crisis_categories);

        MedicalCategory = (ImageButton) findViewById(R.id.MedicalCategory);
        FireCategory = (ImageButton) findViewById(R.id.FireCategory);
        AccidentCategory = (ImageButton) findViewById(R.id.AccidentCategory);


        //get the email of the user
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        ab.setSubtitle(nameFromIntent);

        MedicalCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                new AlertDialog.Builder(CrisisCategoriesActivity.this, R.style.MyDialogTheme)

                        .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                        .setMessage("Do you want to choose specific Medical crisis?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intentMedicalCategory = new Intent(getApplicationContext(), MedicalCategoriesActivity.class);
                                startActivity(intentMedicalCategory);


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CrisisCategoriesActivity.this, "You have sent general medical crisis", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        MedicalCategory.setOnLongClickListener(new View.OnLongClickListener() {

            @SuppressLint("WrongConstant")
            @Override

            public boolean onLongClick(View v) {

                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(),

                        "You have sent Medical Crisis", 2000).show();

                return true;

            }

        });

        AccidentCategory.setOnLongClickListener(new View.OnLongClickListener() {

            @SuppressLint("WrongConstant")
            @Override

            public boolean onLongClick(View v) {

                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(),

                        "You have sent Accident Crisis", 2000).show();

                return true;

            }

        });

        FireCategory.setOnLongClickListener(new View.OnLongClickListener() {

            @SuppressLint("WrongConstant")
            @Override

            public boolean onLongClick(View v) {

                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(),

                        "You have sent Fire Crisis", 2000).show();

                return true;

            }

        });

        FireCategory.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), "Fire Categories",

                        1000)
                        .show();

            }

        });

    }
}