package com.example.swapnil.ruralapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class electricity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView t1;
    String s0,s1,s2,s3,s4;

    Spinner spin;
   String[] country = {"Chandranagar","Gitapuri","Rampur","Sitapur","Virpur",  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);
    t1=(TextView)findViewById(R.id.textView6);
        spin=(Spinner)findViewById(R.id.spinner2);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = mDatabase.getReference("Electricity");
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
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // discription.setText(country[i]);
        if(i==0)
            t1.setText(s0);
        else if(i==1)
            t1.setText(s1);
        else if(i==2)
            t1.setText(s2);
        else if(i==3)
            t1.setText(s3);
        else
            t1.setText(s4);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

