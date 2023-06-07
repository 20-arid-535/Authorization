package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Verify extends AppCompatActivity {

    EditText password;
String s;
    Button signupButton;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        password = findViewById(R.id.password);
        password.setText("1234");
        login = (TextView) findViewById(R.id.signupText);
        Intent i = getIntent();
         s = i.getStringExtra("key");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Signup.this, "login!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Verify.this,ForgetPass.class);
                startActivity(i);
            }
        });
        signupButton = findViewById(R.id.loginButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals("1234") && password.getText().toString().length()!=0 ) {
                    Toast.makeText(Verify.this, "verify  Successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Verify.this,Restpass.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Verify.this, " Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}