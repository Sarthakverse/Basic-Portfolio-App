package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.portfolioapp.model.Courses;
import com.example.portfolioapp.model.Education;
import com.example.portfolioapp.model.Portfolio;

public class activity2add extends AppCompatActivity {

    public static final String PARAM_PORTFOLIO = "param-portfolio";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2add);
    }

    public void submitData(View view) {

        EditText etNameid = findViewById(R.id.NAME_ID);
        EditText etPositionid = findViewById(R.id.POSITION_ID);
        EditText etCollegeid = findViewById(R.id.COLLEGE_ID);
        EditText etDegreeid = findViewById(R.id.DEGREE_ID);
        EditText etEducationYearid = findViewById(R.id.EDUCATION_YEAR_ID);
        EditText etOrganisationid = findViewById(R.id.ORGANISATION_NAME_ID);
        EditText etCourseid = findViewById(R.id.COURSE_ID);
        EditText etCourseYearid = findViewById(R.id.COURSE_YEAR_ID);
        EditText etEnterGithubUserNameid = findViewById(R.id.GITHUB_ID);

       if(etNameid.getText().toString().isEmpty()||etNameid.getText()==null)
       {
           etNameid.setError("Valid Name mandatory");
           etNameid.requestFocus();
       }

       //Objectkanaam.getText().toString

        Education education = new Education(etCollegeid.getText().toString(),etDegreeid.getText().toString(),etEducationYearid.getText().toString());

       Courses course = new Courses(etOrganisationid.getText().toString(),etCourseid.getText().toString(),etCourseYearid.getText().toString());

       Portfolio portfolio = new Portfolio(etNameid.getText().toString(),etPositionid.getText().toString(),education,course,etEnterGithubUserNameid.getText().toString());

     Intent intent = new Intent();
     intent.putExtra(PARAM_PORTFOLIO,portfolio);
     setResult(RESULT_OK,intent);
     //activity2add lifecycle will end here
     finish();


    }

}