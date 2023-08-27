package com.example.portfolioapp;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.portfolioapp.model.Portfolio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/** @noinspection deprecation*/
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_DETAILS_CODE = 1337;
    private static final String TAG = "Main Activity";
    private String githubusername =null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addDetailsButton = findViewById(R.id.MAIN_ADD_BUTTON_ID);
        addDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity2add.class);
                startActivityForResult(intent, REQUEST_DETAILS_CODE);
            }
        });
    }

    public void openGithub(View view)
    {
        String githuburl = "https://github.com/";
        if(githubusername!=null)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"+githubusername));
            startActivity(intent);

        }
        else {
            Toast.makeText(MainActivity.this,"No Github username found!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAILS_CODE && resultCode == RESULT_OK && data != null) {
               Portfolio portfolio = data.getParcelableExtra(activity2add.PARAM_PORTFOLIO);
               if(portfolio!=null)
               {
                   setDetails(portfolio);
               }
        }
    }

    private void setDetails(@NonNull Portfolio portfolio)
    {
        //first we check by printing portfolio
        Log.i(TAG,String.valueOf(portfolio));

        //then we set data to appropriate fields
        TextView nameid = findViewById(R.id.NAME_ID);
        TextView positionalid = findViewById(R.id.POSITION_ID);
        TextView universityid = findViewById(R.id.COLLEGE_ID);
        TextView degreeid = findViewById(R.id.DEGREE_ID);
        TextView Educationyearid = findViewById(R.id.EDUCATION_YEAR_ID);
        TextView Organisationid = findViewById(R.id.ORGANISATION_NAME_ID);
        TextView Coursenameid = findViewById(R.id.COURSE_ID);
        TextView courseyearid = findViewById(R.id.COURSE_YEAR_ID);
        TextView githubusernameid = findViewById(R.id.GITHUB_ID);


        nameid.setText(portfolio.getSecondary_name());
        positionalid.setText(portfolio.getSecondary_position());
        universityid.setText(portfolio.getEducation().getSecondary_college());
        degreeid.setText(portfolio.getEducation().getSecondary_degree());
        Educationyearid.setText(portfolio.getEducation().getSecondary_education_year());
        Organisationid.setText(portfolio.getCourses().getSecondary_organisation_name());
        Coursenameid.setText(portfolio.getCourses().getSecondary_course_name());
        courseyearid.setText(portfolio.getCourses().getSecondary_course_year());

        //set github user name
        githubusername = portfolio.getGitHubUserName();
    }
}