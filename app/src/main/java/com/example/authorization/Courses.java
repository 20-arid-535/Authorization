package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class Courses extends AppCompatActivity {
    public static String SelectedItem="";
    int [] imagId = { R.drawable.c4, R.drawable.c2 ,R.drawable.c1, R.drawable.c3};
    String[] itemName = {"Introdution to Java", "Flutter and Dart","Web development", "Computer Graphic"};
    String [] itemDesc = {"Java is a high-level, object-oriented programming language. ", "Flutter is Google's portable UI toolkit for crafting applications for mobile.","Web development is the building and maintenance of websites.", "Computer graphics is an art of drawing pictures on computer screens."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        CustomListAdapter adapter1 = new CustomListAdapter(this, imagId, itemName, itemDesc);
        GridView list = (GridView)findViewById(R.id.list);
        list.setAdapter(adapter1);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                SelectedItem= itemName[+position];
                Toast.makeText(getApplicationContext(), SelectedItem, Toast.LENGTH_SHORT).show();
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
                Intent i1 = new Intent(Courses.this,Courses.class);
                startActivity(i1);
        return true;
            case R.id.action_about:
            //    Toast.makeText(Courses.this, "Contact", Toast.LENGTH_SHORT).show();
         Intent i2 = new Intent(Courses.this,Contact.class);
         startActivity(i2);
        return true;
        case R.id.action_help:
            Intent i3 = new Intent(Courses.this,MainActivity.class);
            startActivity(i3);
        return true;
            case R.id.action_help1:
                Intent i4 = new Intent(Courses.this,MapsActivity.class);
                startActivity(i4);
                return true;
        default:
            return super.onOptionsItemSelected(item);
        }
         }

}