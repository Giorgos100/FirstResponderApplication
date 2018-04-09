package giorgos.FirstResponderApplication.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import giorgos.FirstResponderApplication.R;
import giorgos.FirstResponderApplication.LocalDatabase.DatabaseHelper;


public class MainActivity extends AppCompatActivity {

    public DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar AB = getSupportActionBar();
     //   String b= databaseHelper.getEmails();
      //  AB.setSubtitle(b);



    }

    boolean doubleBackToExitPressedOnce = false;
    // If back pressed twice then (exit)
    @Override
    public void onBackPressed()
    {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
                finish();
            }
        }, 2000);
    }
    public void showMyLocation(View view)
    {
      startActivity(new Intent(getApplicationContext(),CrisisCategoriesActivity.class));
    }
}
