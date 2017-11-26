package com.example.shama.proj1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText logName;
    EditText logID;
    Button login;

    public void homeB(){
        login = (Button) findViewById(R.id.loginB);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent (LoginActivity.this,Home.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logName = (EditText) findViewById(R.id.Name);
        logID = (EditText) findViewById(R.id.ID);
        login =(Button) findViewById(R.id.loginB);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        homeB();
    }
}
