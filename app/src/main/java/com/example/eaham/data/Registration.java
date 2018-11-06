package com.example.eaham.data;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Registration extends AppCompatActivity {
    private EditText name,address,bloodgroup,password,mobile;
    private Button register;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.setTitle("Register Activity");

        mobile = (EditText) findViewById(R.id.editText6);
        name = (EditText) findViewById(R.id.editText);
        address = (EditText) findViewById(R.id.editText3);
        bloodgroup = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        mdatabase=FirebaseDatabase.getInstance().getReference();



        register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {

                   String username=name.getText().toString().trim();
                   String userpass=password.getText().toString().trim();

                   //firebaseAuth.createUserWithEmailAndPassword(username,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {


                           if(task.isSuccessful())
                           {
                               Toast.makeText(Registration.this,"Registrtation Successful",Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(Registration.this,MainActivity.class));


                           }
                           else {
                               Toast.makeText(Registration.this,"Registrtation failed",Toast.LENGTH_SHORT).show();
                           }

                       }
                   });





                }
            }
        });





    }

    private boolean validate()
    {
        boolean result = false;
        String mob = mobile.getText().toString();
        String add = address.getText().toString();
        String nam = name.getText().toString();
        String bg = bloodgroup.getText().toString();
        String pass = password.getText().toString();

        if ((mob.isEmpty()) || (add.isEmpty()) || (nam.isEmpty()) || (bg.isEmpty()) || (pass.isEmpty()))
        {
            Toast.makeText(Registration.this, "Please fill all the credentials", Toast.LENGTH_SHORT).show();
        }
        else
            {
            return result = true;
        }

        return result;




    }


}

