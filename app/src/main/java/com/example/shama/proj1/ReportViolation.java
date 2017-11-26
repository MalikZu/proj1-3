package com.example.shama.proj1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

import static android.view.View.*;


public class ReportViolation extends AppCompatActivity implements OnItemSelectedListener {
    //////////////////////////// declearing///////
    Button buttonSub, buttonPic;
    ImageView picView;
    EditText editTextID, editTextBUILD, editTextFLOOR, editTextROOM, editTextDESC;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_violation);
        ////////// first spinner ////

        List<String> a=new ArrayList<String>();
        a.add("Main Campus");
        a.add("Sas AlNakhal Campus");
        a.add("Masdar Campus");
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,a);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        /////////////////////////////////// second spinner///////////////////////////////////////////
        List<String> b=new ArrayList<String>();
        b.add("Dress code");
        b.add("littering");
        b.add("Unpermitted group gatherings");
        b.add("Parking violation");
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,b);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);



        //// picture /////

        buttonPic= (Button) findViewById(R.id.buttonPic);
        picView = (ImageView) findViewById(R.id.imageView);
        buttonPic.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent i= new Intent (MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(i,0);
            }});


        //////////submit button //////////////

        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {


                ///go to another activity

                Intent i= new Intent (ReportViolation.this,Submition.class);
                startActivity(i);}});

        //String time = getCurrentTimeStamp();

    }

        ///// for taking pictures.

        protected void  onActivityResult(int requestCode , int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        Bitmap bitmap =(Bitmap) data.getExtras().get("data");
        picView.setImageBitmap(bitmap);

    }
    //////////// timestamp/////////








    ///////////////methods/////////////////
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String sSelected=parent.getItemAtPosition(position).toString();
    Toast.makeText(this,sSelected,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}}
