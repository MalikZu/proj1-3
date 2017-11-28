package com.example.shama.proj1;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    ListView choices;
    Button save;
    TextView text;
    TextView text4;
    TextView text8;
    EditText name;
    EditText pass;
    EditText DOB;
    EditText id;
    String s1="";
    EditText Gender;
    EditText studentEmail;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        text = (TextView) findViewById(R.id.textView3);
        Intent i = getIntent();
        String typeText = i.getStringExtra("Source");
        text.setText(typeText);
        text8 = (TextView) findViewById(R.id.textView8);
        text4 = (TextView) findViewById(R.id.textView4);
        name = (EditText) findViewById(R.id.editText);
//        email = (EditText) findViewById(R.id.editText);
        id = (EditText) findViewById(R.id.editText2);
        pass = (EditText) findViewById(R.id.editText3);
        DOB = (EditText) findViewById(R.id.editText4);
        Gender = (EditText) findViewById(R.id.editText7);
        save = (Button) findViewById(R.id.button3);
        choices = (ListView) findViewById(R.id.list);
        final String[] itemsArray = {"Main Campus", "Sas AlNakhl Campus", "Masdar Campus"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itemsArray);
        choices.setAdapter(adapter);



        choices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                s1 = itemsArray[position];
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = studentEmail.getText().toString();
                String password = pass.getText().toString();


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            public static final String TAG = "FBLog";

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
            }
        });

    }

    private void updateUI(FirebaseUser currentUser) {

    }
}
