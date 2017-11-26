package com.example.shama.proj1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.view.View;


public class Submition extends AppCompatActivity {
    Button buttonAgain;

    /// sending email //////
    public void process (View view){


        if(view.getId()==R.id.SendEmail)
        {Intent a = new Intent(Intent.ACTION_SEND);
            a.setData(Uri.parse("mailto:"));
            String emailList[] ={"100042601@kustar.ac.ae"};
            a.putExtra(Intent.EXTRA_EMAIL, emailList);
            a.putExtra(Intent.EXTRA_SUBJECT, "VIOLATION WARNING!!!");
            a.putExtra(Intent.EXTRA_TEXT, "A violation has been registered against you\n" +
                    "To track it, please log in to your Violation application");
            a.setType("message/rfc822");
            Intent chooser=Intent.createChooser( a,"choose email app");
            startActivity(chooser);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submition);


    //////////button//////////////
        buttonAgain = (Button) findViewById(R.id.buttonAgain);
        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Submition.this, ReportViolation.class);
                startActivity(i);
            }
        });
    }
}
/////////////end of button///////////
