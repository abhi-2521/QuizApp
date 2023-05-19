package com.example.growknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();
        Handler handler;
        handler=new Handler();
        int time=3000;
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splashscreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable,time);
//        Thread thread=new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(2200);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                finally {
//
//                }
//            }
//        };thread.start();

    }
}