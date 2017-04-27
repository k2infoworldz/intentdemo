package com.coolacharya.intentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView userid, uesrname, userposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String id = getIntent().getExtras().getString("id");
        String name = getIntent().getExtras().getString("Name");
        String Position = getIntent().getExtras().getString("Position");

        userid = (TextView) findViewById(R.id.id);
        userid.setText(id);
        uesrname = (TextView) findViewById(R.id.name);
        uesrname.setText(name);
        userposition = (TextView) findViewById(R.id.position);
        userposition.setText(Position);
        Toast.makeText(this, "Value is:" + id + " " + name + " " + Position,
                Toast.LENGTH_LONG).show();
    }
}
