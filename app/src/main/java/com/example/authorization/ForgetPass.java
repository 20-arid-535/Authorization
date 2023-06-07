package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import papaya.in.sendmail.SendMail;

public class ForgetPass extends AppCompatActivity {
    EditText email;
String s;
public static String s1="";
    Button sendButton;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
Random r = new Random();
 s=String.valueOf(r.nextInt((9999-100)+1)+10);
        email = findViewById(R.id.username1);
        email.setText("nomanarid@gmail.com");
        sendButton = findViewById(R.id.loginButton);

        login = (TextView) findViewById(R.id.signupText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Signup.this, "login!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ForgetPass.this,MainActivity.class);
                startActivity(i);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().length()!=0) {
                    s1=email.getText().toString();
                    SendMail mail = new SendMail("zeeshanmasood04181613021@gmail.com", "nuevzfwlxfoqjeby",
                            email.getText().toString().trim(),
                            "Testing Email Sending",
                            "The verification code is : "+s);
                    mail.execute();
                    Toast.makeText(ForgetPass.this, "send Successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ForgetPass.this,Verify.class);
                    i.putExtra("key",s);
                    startActivity(i);
                } else {
                    Toast.makeText(ForgetPass.this, " Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}