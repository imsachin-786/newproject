package com.fms.pinki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1, e2, e3,e4,e5;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.source);
        e2 = (EditText) findViewById(R.id.dest);
        e3 = (EditText) findViewById(R.id.trainname);
        e3 = (EditText) findViewById(R.id.trainno);
        e3 = (EditText) findViewById(R.id.fare);
        b1 = (Button) findViewById(R.id.add);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String s1 = e1.getText().toString();
                                      String s2 = e2.getText().toString();
                                      String s3 = e3.getText().toString();
                                      String s4 = e4.getText().toString();
                                      String s5 = e5.getText().toString();
                                      if (s1.equals("") || s2.equals("") || s3.equals("")||s4.equals("")||s5.equals("")) {
                                          Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                                      } else {
                                                  Boolean insert = db.insert(s1, s2,s3,s4,s5);
                                                  if (insert == true) {
                                                      Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                                                  }
                                                  else{
                                                      Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                                                  }
                                              }
                                          }

                              }
        );

    }
}