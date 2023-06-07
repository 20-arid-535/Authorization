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

public class Result extends AppCompatActivity {
    TextView tv, tv2, tv3,tv1;
    Button btnRestart,btncert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv1 = (TextView)findViewById(R.id.tvres1);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btncert = (Button) findViewById(R.id.btnRestart1);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + Quiz.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + Quiz.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + Quiz.correct + "\n");

        int sb4= Quiz.correct ;
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Quiz.correct=0;
        Quiz.wrong=0;
        if(sb4>=9){
            tv1.setText("Congratulate! You passsed the Course ");
            btncert.setEnabled(true);

        }
        else{
            tv1.setText("Better luck next time");

            btncert.setEnabled(false);
        }
        btncert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),Certificate.class);
                startActivity(in);
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),Rules.class);
                startActivity(in);
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
                Intent i1 = new Intent(Result.this,Courses.class);
                startActivity(i1);
                return true;
            case R.id.action_about:
            //    Toast.makeText(Result.this, "Contact", Toast.LENGTH_SHORT).show();
               Intent i2 = new Intent(Result.this,Contact.class);
                startActivity(i2);
                return true;
            case R.id.action_help:
                Intent i3 = new Intent(Result.this,MainActivity.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
