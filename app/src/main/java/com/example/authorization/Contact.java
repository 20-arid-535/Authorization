package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contact extends AppCompatActivity {

    EditText username,email;
    EditText password;
    EditText confirmpassword;
    Button signupButton;
    TextView login;
    DBHelper DB;
    String s11,s12,s13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        username = findViewById(R.id.username);
        email = findViewById(R.id.username1);
        password = findViewById(R.id.password);

        signupButton = findViewById(R.id.loginButton);

       // DB = new DBHelper(this);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().length()!=0 &&  password.getText().toString().length()!=0 && email.getText().toString().length()!=0) {
                    s11=username.getText().toString();
                    s12=email.getText().toString();
                    s13=password.getText().toString();
                    //Boolean checkinsertdata = DB.insertuserdata(s11, s12,s13 );
                   // if(checkinsertdata==true) {
                      //  Toast.makeText(Signup.this, "create Successful!", Toast.LENGTH_SHORT).show();
                      //  Intent i = new Intent(Signup.this,MainActivity.class);
                     //   startActivity(i);
                  //  }
                   // else
                        Toast.makeText(Contact.this, "Successfull Send!", Toast.LENGTH_SHORT).show();

               }

                else
                {
                    Toast.makeText(Contact.this, "Failed! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch(item.getItemId()) {
            case R.id.action:
                Intent i1 = new Intent(Contact.this,Courses.class);
                startActivity(i1);
                return true;
            case R.id.action_about:
                //Toast.makeText(Contact.this, "Contact", Toast.LENGTH_SHORT).show();
              Intent i2 = new Intent(Contact.this,Contact.class);
              startActivity(i2);
                return true;
            case R.id.action_help:
                Intent i3 = new Intent(Contact.this,MainActivity.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

