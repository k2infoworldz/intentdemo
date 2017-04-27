package com.coolacharya.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.coolacharya.util.IntentUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_CODE = 1;
    private Bitmap bitmap;
    private ImageView imageView;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.button_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Explicit Intent
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("id", "AA1257561237");
                i.putExtra("Name", "Kaushal kishore");
                i.putExtra("Position", "Android Developer");
                startActivity(i);
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        imageView = (ImageView) findViewById(R.id.result);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        Log.d(TAG, "The onCreate() event");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        switch (item.getItemId()) {
            case R.id.action_about:

                //Implicit Activity
                IntentUtils.openUrl(this, "https://github.com/kaushalkishore1");
                break;
            case R.id.action_about_me:
                IntentUtils.openUrl(this, "https://in.linkedin.com/in/kaushal-kishore-96910758");
                break;
        }
        return super.onOptionsItemSelected(item);


    }

    public void onClick(View view) {
        //Implicit Activity
        int position = spinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.vogella.com"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:(+49)12345789"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+49)12345789"));
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:50.123,7.1434?z=19"));
                break;
            case 4:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=query"));
                break;
            case 5:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 6:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
            case 7:
                intent = new Intent(Intent.ACTION_EDIT,
                        Uri.parse("content://contacts/people/1"));
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            String result = data.toURI();
            Toast.makeText(this, result, Toast.LENGTH_LONG);
        }

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
            try {
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);

                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (stream != null)
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
    }

    public void pickImage(View View) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() event");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "The onDestroy() event");
    }


}
