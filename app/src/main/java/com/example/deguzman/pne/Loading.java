package com.example.deguzman.pne;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import cz.msebera.android.httpclient.Header;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;


public class Loading extends AppCompatActivity {
    Button act, sw;
    CircularProgressButton circularProgressButton;
    RingProgressBar progressBar;
    Handler myHandler;

    int progress = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        progressBar = (RingProgressBar) findViewById(R.id.progress);
        ringProgress();


    }

    public void ringProgress() {
        progressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {
                startActivity(new Intent(Loading.this, ScanActivity.class));
            }
        });
        myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==0){
                    if (progress<100){
                        progress++;
                        progressBar.setProgress(progress);
                    }
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(700);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}









