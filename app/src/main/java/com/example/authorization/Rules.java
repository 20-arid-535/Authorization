package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Rules extends AppCompatActivity {
 TextView tv ;
 Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        b1 = findViewById(R.id.loginButton);
        b2 = findViewById(R.id.loginButton1);
        tv = (TextView) findViewById(R.id.username);
        tv.setText(
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "\n" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "\n" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "\n" +
                "4. Crying is allowed but please do so quietly."+ "\n" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "\n"
                );
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "forget!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Rules.this,Quiz.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "forget!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Rules.this,Lecture.class);
                startActivity(i);
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
                Intent i1 = new Intent(Rules.this,Courses.class);
                startActivity(i1);
                return true;
            case R.id.action_about:
                Toast.makeText(Rules.this, "Contact", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Rules.this,Contact.class);
               startActivity(i2);
                return true;
            case R.id.action_help:
                Intent i3 = new Intent(Rules.this,MainActivity.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}