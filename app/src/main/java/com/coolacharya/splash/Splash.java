package com.coolacharya.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.coolacharya.intentdemo.MainActivity;
import com.coolacharya.intentdemo.R;

public class Splash extends AppCompatActivity {

    boolean perm1 = false;
    boolean perm2 = false;
    boolean perm3 = false;
    boolean perm4 = false;
    boolean perm5 = false;
    boolean perm6 = false;
    boolean perm7 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions();
        } else {
            Intent i = new Intent(Splash.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    perm1 = true;
                    requestPermissions();
                } else {
                    finish();
                }
                break;
            }
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    perm2 = true;
                    requestPermissions();
                } else {
                    finish();
                }
                break;
            }
            case 2: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    perm3 = true;
                    requestPermissions();
                } else {
                }
                break;
            }
            case 3: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    perm4 = true;
                    requestPermissions();
                } else {
                    finish();
                }
                break;
            }
            case 4: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    perm4 = true;
                    requestPermissions();
                } else {
                    finish();
                }
                break;
            }
            case 5: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    perm5 = true;
                    requestPermissions();
                } else {
                    finish();
                }
                break;
            }
        }
    }

    public void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            if (!perm1) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 0);
            }
        } else {
            perm1 = true;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (!perm2 && perm1) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        } else {
            perm2 = true;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (!perm3 && perm2 && perm1) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 2);
            }
        } else {
            perm3 = true;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            if (!perm4 && perm3 && perm2 && perm1) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 3);
            }
        } else {
            perm4 = true;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (!perm5 && perm4 && perm3 && perm2 && perm1) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 4);
            }
        } else {
            perm5 = true;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (!perm6 && perm5 && perm4 && perm3 && perm2 && perm1) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 4);
            }
        } else {
            perm6 = true;
        }


        if (perm1 && perm2 && perm3 && perm4 && perm5 && perm6) {
            Intent i = new Intent(Splash.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
