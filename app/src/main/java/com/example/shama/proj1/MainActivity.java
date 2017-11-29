package com.example.shama.proj1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button reg;
    Button log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg = (Button) findViewById(R.id.button);
        log = (Button) findViewById(R.id.button2);

        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SelectRole.class);
                startActivity(i);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivity(i);
            }
        });



    }
}

