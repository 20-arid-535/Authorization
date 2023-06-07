package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.ReplacementTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText username,email;
    EditText password;
    EditText confirmpassword;
    Button signupButton;
    TextView login;
    DBHelper DB;
    String s11,s12,s13;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = findViewById(R.id.username);
        email = findViewById(R.id.username1);
        password = findViewById(R.id.password);
        cb = findViewById(R.id.forget);
        confirmpassword = findViewById(R.id.confirmpass);
        signupButton = findViewById(R.id.loginButton);
        username.setText("Noman");
        email.setText("nomanarid@gmail.com");
        password.setText("1234");
        confirmpassword.setText("1234");
        login = (TextView) findViewById(R.id.signupText);
        DB = new DBHelper(this);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
password.setTransformationMethod(null);
                   confirmpassword.setTransformationMethod(null);
                }
                else{
password.setTransformationMethod(new PasswordTransformationMethod());
confirmpassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Signup.this, "login!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Signup.this,MainActivity.class);
                startActivity(i);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().length()!=0 && password.getText().toString().equals(confirmpassword.getText().toString()) && password.getText().toString().length()!=0 && email.getText().toString().length()!=0) {
                    s11=username.getText().toString();
                     s12=email.getText().toString();
                    s13=password.getText().toString();
                    Boolean checkinsertdata = DB.insertuserdata(s11, s12,s13 );
                    if(checkinsertdata==true) {
                        Toast.makeText(Signup.this, "create Successful!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Signup.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(Signup.this, "Failed!", Toast.LENGTH_SHORT).show();

                }

                else
                {
                    Toast.makeText(Signup.this, " Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}