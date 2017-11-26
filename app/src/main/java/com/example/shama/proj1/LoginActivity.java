package com.example.shama.proj1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText logName;
    EditText logID;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logName = (EditText) findViewById(R.id.Name);
        logID = (EditText) findViewById(R.id.ID);
        ok =(Button) findViewById(R.id.button6);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
