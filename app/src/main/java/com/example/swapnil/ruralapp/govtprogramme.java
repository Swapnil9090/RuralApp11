package com.example.swapnil.ruralapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.attr.country;

public class govtprogramme extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView t1;
    ListView listView;
    String[] country = {"Chandranagar","Gitapuri","Rampur","Sitapur","Virpur",};
    String s0,s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govtprogramme);
        t1 = (TextView) findViewById(R.id.textView4);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = mDatabase.getReference("GovtProg");
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                s0=dataSnapshot.child("chandranagar").getValue().toString();
                s1=dataSnapshot.child("gitapur").getValue().toString();
                s2=dataSnapshot.child("rampur").getValue().toString();
                s3=dataSnapshot.child("sitapur").getValue().toString();
                s4=dataSnapshot.child("virpur").getValue().toString();
                // Toast.makeText(getApplicationContext(),s0,Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });



        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


    }
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // discription.setText(country[i]);
               try{ if(i==0){
                   // Log.d("So","" +s0 + " " + s1);
                 /*   String[] a=s0.split(",");
                    s0="";
                    for(int k=0;k<a.length;k++){
                        s0=s0+a[k]+"\n";
                    }*/
                    t1.setText(s0);
                }
                else if(i==1){
                    String[] a=s1.split(",");
                    s1="";
                    for(int k=0;k<a.length;k++){
                        s1=s1+a[k]+"\n";
                    }
                    t1.setText(s1);
                }
                else if(i==2)
                {
                    String[] a=s2.split(",");
                    s2="";
                    for(int k=0;k<a.length;k++){
                        s2=s2+a[k]+"\n";
                    }
                    t1.setText(s2);
                }
                else if(i==3){
                    String[] a=s3.split(",");
                    s3="";
                    for(int k=0;k<a.length;k++){
                        s3=s3+a[k]+"\n";
                    }
                    t1.setText(s3);
                }
                else{
                    String[] a=s4.split(",");
                    s4="";
                    for(int k=0;k<a.length;k++){
                        s4=s4+a[k]+"\n";
                    }
                    t1.setText(s4);
                }}catch (NullPointerException e)
                {
                    Toast.makeText(this,"NO INTERNET CONNECTIVITY",Toast.LENGTH_LONG).show();
                }
                finally {

                }


                //Toast.makeText(getApplicationContext(),country[i] ,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
}