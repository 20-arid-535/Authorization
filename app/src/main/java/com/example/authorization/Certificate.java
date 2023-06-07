package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Certificate extends AppCompatActivity {
    Button loginButton;
    Button loginButton1;
    TextView t1,t2;
    RelativeLayout content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        loginButton = findViewById(R.id.loginButton);
        loginButton1 = findViewById(R.id.loginButton1);
        t1=findViewById(R.id.tvres);
        t2=findViewById(R.id.tvres1);
        t1.setText(MainActivity.s);
        t2.setText(Courses.SelectedItem);
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = findViewById(R.id.r1);
                content.setDrawingCacheEnabled(true);
                content.buildDrawingCache();
                content.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
                Bitmap bitmap = content.getDrawingCache();
                String root =Environment.getExternalStorageDirectory().getAbsolutePath();
                File file= new File(root+"/Download");
                File myfile= new File(file,Courses.SelectedItem+"_UIIT_Certificate.jpg");
                if (myfile.exists()) {
                    myfile.delete();
                }
                try {
                FileOutputStream ostream = new FileOutputStream(myfile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                ostream.flush();
                ostream.close();
                Toast.makeText(Certificate.this, "Successfull!", Toast.LENGTH_SHORT).show();
                content.setDrawingCacheEnabled(false);
                    }
                catch (Exception e) {
                        e.printStackTrace();
                    Toast.makeText(Certificate.this, "Failled!", Toast.LENGTH_SHORT).show();

                }
                }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "forget!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Certificate.this,Courses.class);
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
                Intent i1 = new Intent(Certificate.this,Courses.class);
                startActivity(i1);
                return true;
            case R.id.action_about:
                Toast.makeText(Certificate.this, "Contact", Toast.LENGTH_SHORT).show();
//                Intent i2 = new Intent(Courses.this,Courses.class);
//                startActivity(i2);
                return true;
            case R.id.action_help:
                Intent i3 = new Intent(Certificate.this,MainActivity.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}