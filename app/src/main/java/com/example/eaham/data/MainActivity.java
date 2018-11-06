package com.example.eaham.data;

import android.net.sip.SipErrorCode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

   private Button login;
   private EditText name,pass;
   private TextView tv1;
   private DatabaseReference mdatabase;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Login Section");
        login = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editText1);



        pass = (EditText) findViewById(R.id.editText2);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,Registration.class);
                startActivity(in);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result1=name.getText().toString();
                String result2=pass.getText().toString();

                if((result1.isEmpty())||(result2.isEmpty()))
                {
                    Toast.makeText(MainActivity.this,"Sorry Please fill All Details ",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    mdatabase=FirebaseDatabase.getInstance().getReference("User/"+result1);

                    mdatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String password = dataSnapshot.child("password").getValue().toString().trim();










                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });














                    Intent in=new Intent(MainActivity.this,Registration.class);
                    startActivity(in);
                    //validate(name.getText().toString(), pass.getText().toString());
                }


            }
        });


    }





    }

