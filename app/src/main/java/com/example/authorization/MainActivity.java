package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    TextView forget,signup;
    public static String s="";
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = new DBHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        forget = (TextView) findViewById(R.id.forget);
        signup = (TextView) findViewById(R.id.signupText);
username.setText("Noman");
password.setText("1234");
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Toast.makeText(MainActivity.this, "forget!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,ForgetPass.class);
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "signup!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,Signup.class);
                startActivity(i);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().length()!=0 && password.getText().toString().length()!=0) {
                    String s11=username.getText().toString();
                    String s12= password.getText().toString();
                    Cursor res = DB.getdatas(s11);
                    if(res.getCount()==0){
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                    else {
                    String name = new String();
                    String pass = new String();
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                           name =res.getString(0);
                           pass=res.getString(2);
                        }
                    if (s11.equals(name) && s12.equals(pass)) {
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        s = username.getText().toString();
                        Intent i = new Intent(MainActivity.this, Courses.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
                }
                else {
                    Toast.makeText(MainActivity.this, "Login in Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
