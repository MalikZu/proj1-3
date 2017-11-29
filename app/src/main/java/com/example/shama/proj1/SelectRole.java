package com.example.shama.proj1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class SelectRole extends AppCompatActivity {

    ListView choices;
    TextView txt1;
    TextView txt;
    Button start;
    Button back;
    String s1= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);
        txt = (TextView) findViewById(R.id.textView);
        txt1 = (TextView) findViewById(R.id.textView2);
        start = (Button) findViewById(R.id.button3);
        back = (Button) findViewById(R.id.button4);
        choices = (ListView) findViewById(R.id.list1);
        final String[] itemsArray = {"Student", "Security"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itemsArray);
        choices.setAdapter(adapter);

        choices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                System.out.println(position);
                s1 = itemsArray[position];
                System.out.println(s1);

            }
        });

        start.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent i=new Intent(SelectRole.this,Register.class);
                System.out.println(s1);
//                i.putExtra("Source",
//                        "you are a "+s1);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent i=new Intent(SelectRole.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}

