package com.example.shama.proj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentViolations extends AppCompatActivity {
    public Button button11, Hbutton1;



    // recording violation by student "button"
    public void VioB(){
        button11 = (Button) findViewById(R.id.button1);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent (StudentViolations.this,ReportViolation.class);
                startActivity(i);
            }
        });
    }
    public void homeB(){
        Hbutton1 = (Button) findViewById(R.id.Hbutton1);

        Hbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent (StudentViolations.this,Home.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_violations);
        homeB();
        VioB();

    }}


