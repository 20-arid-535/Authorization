package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Restpass extends AppCompatActivity {
    EditText username,email;
    EditText password;
    EditText confirmpassword;
    Button signupButton;
    TextView login;
    DBHelper DB1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restpass);
        DB1 = new DBHelper(this);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpass);
        password.setText("1234");
        confirmpassword.setText("1234");
        signupButton = findViewById(R.id.loginButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(confirmpassword.getText().toString()) && password.getText().toString().length()!=0 ) {
                    String ss1=password.getText().toString();
                    String ss2=ForgetPass.s1;
                    Boolean checkupdatedata = DB1.updateuserdata(ss1, ss2 );
                    if(checkupdatedata==true) {
                        Toast.makeText(Restpass.this, "reset Successful!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Restpass.this, MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Restpass.this, "not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Restpass.this, " Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}