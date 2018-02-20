package com.example.swapnil.ruralapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.country;

public class Yardprice extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView t;
    DatabaseReference mDatabase;
    String s0,s4,s1,s2,s3,str;
    String[] country = {"Ahemdabad","Junagadh","Rajkot","Vadodara",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardprice);
        t=(TextView)findViewById(R.id.textView8);
        Spinner spin = (Spinner) findViewById(R.id.spinner5);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        str=country[i];
       // t.setText(str);
       display(str);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void display(String str)
    {
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = mDatabase.getReference(str);
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               // s0=dataSnapshot.child("cotton").getValue().toString();
                s1=dataSnapshot.child("groundnut").getValue().toString();
                s2=dataSnapshot.child("rice").getValue().toString();
                s4=dataSnapshot.child("jowar").getValue().toString();
                s3=dataSnapshot.child("wheat").getValue().toString();

      t.setText("Jowar : "+"\t"+s4+"\n"+"Groundnut :"+"\t"+s1+"\n"+"Rice : "+"\t"+s2+"\n"+
                    "Wheat : "+"\t"+s3);
                // Toast.makeText(getApplicationContext(),s0,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
