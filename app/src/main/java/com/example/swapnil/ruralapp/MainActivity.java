package com.example.swapnil.ruralapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    ImageButton weather,grants,programe,electricity,price;
    public String s0,s1,s2,s3,s4;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weather=(ImageButton)findViewById(R.id.imageButton3);
        grants=(ImageButton)findViewById(R.id.imageButton4);
        programe=(ImageButton)findViewById(R.id.imageButton5);
        electricity=(ImageButton)findViewById(R.id.imageButton6);
        price =(ImageButton)findViewById(R.id.imageButton7);

     /*   FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = mDatabase.getReference("GovtGrant");
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                s0=dataSnapshot.child("chandranagar").getValue().toString();
                s1=dataSnapshot.child("gitapur").getValue().toString();
                s2=dataSnapshot.child("rampur").getValue().toString();
                s3=dataSnapshot.child("sitapur").getValue().toString();
                s4=dataSnapshot.child("virpur").getValue().toString();
               // Toast.makeText(getApplicationContext(),s0,Toast.LENGTH_SHORT).show();
                t9.setText(s0);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/
     b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("EXIT");
                ab.setMessage("Sure Do you want to Exit?");
                ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                ab.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  Toast.makeText(getApplicationContext(),"you have cancelled",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog ad=ab.create();
                ad.show();
            }
        });

    }

   public void GovernPro(View view)
    {
        Intent i=new Intent(MainActivity.this,govtprogramme.class);
        startActivity(i);
    }
    // for yard
    public void YardMethod(View view)
    {
        Intent i=new Intent(MainActivity.this,Yardprice.class);
        startActivity(i);
    }

    public void GrantMethod(View view)
    {
        Intent i = new Intent(MainActivity.this,Grant0.class);
        startActivity(i);
    }

    public void ElectricMethod(View view)
    {
        Intent i=new Intent(MainActivity.this,electricity.class);
        startActivity(i);
    }

    public void WheatherMethod(View view)
    {
        Uri uri = Uri.parse("http://satellite.imd.gov.in/insat.htm"); // missing 'http://' will cause crashed
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }
}
