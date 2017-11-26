package com.example.shama.proj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button button11, Hbutton11;
    // Hbutton11 = (Button) findViewById(R.id.Hbutton1);


    // recording violation by student "button"
public void VioB(){
    button11 = (Button) findViewById(R.id.button1);

    button11.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i= new Intent (MainActivity.this,ReportViolation.class);
            startActivity(i);
        }
    });
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VioB();

    }}


