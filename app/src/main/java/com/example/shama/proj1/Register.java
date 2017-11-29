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
    EditText gender;
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
        studentEmail = (EditText) findViewById(R.id.emailText);
        id = (EditText) findViewById(R.id.editText2);
        pass = (EditText) findViewById(R.id.editText3);
        DOB = (EditText) findViewById(R.id.editText4);
        gender = (EditText) findViewById(R.id.editText7);
        save = (Button) findViewById(R.id.button5);
        choices = (ListView) findViewById(R.id.list);
        final String[] itemsArray = {"Main Campus", "SasAlNakhl Campus", "Masdar Campus"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itemsArray);
        choices.setAdapter(adapter);


        mAuth = FirebaseAuth.getInstance();



        choices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                s1 = itemsArray[position];
                s1= s1.split(" ")[0];
                System.out.print(s1);
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gen= gender.getText().toString();
                Student student= new Student();


                student.setEmail(studentEmail.getText().toString());
                student.setGender((gen.equals("m")||gen.equals("M")||gen.equals("Male")||gen.equals("male"))? Gender.Male:Gender.Female);
                String password = pass.getText().toString();
                student.setCampus(Campus.valueOf(s1));
                student.setDateOfBirth(DOB.getText().toString());
                student.setName(name.getText().toString());

                student.updateFirebase();

                mAuth.createUserWithEmailAndPassword(student.getEmail(), password)
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
