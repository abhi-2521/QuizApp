package com.example.growknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    Intent intent=new Intent(splashscreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }
}