package com.example.shama.proj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rsecurity extends AppCompatActivity {
    public Button buttonSubV, buttonReportViolation ,Hbutton22;

    /// reporting new violation by security "button"

    public void violation(){
        buttonReportViolation = (Button) findViewById(R.id.buttonVio);
        buttonSubV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent (Rsecurity.this,ReportViolation.class);
                startActivity(i);
            }
        });
    }


    //// to view the submitted violation "button"

    public void SumbV(){
        buttonSubV = (Button) findViewById(R.id.buttonSubV);
        buttonSubV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent (Rsecurity.this,Submitted.class);
                startActivity(i);
            }
        });
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsecurity);
        violation();
        SumbV();
    }
}
