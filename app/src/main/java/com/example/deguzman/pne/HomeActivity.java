package com.example.deguzman.pne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button library = (Button) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Library.class);
                startActivity(i);
            }
        });

        Button scan = (Button) findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, AddPlantActivity.class);
                startActivity(i);
            }
        });


        Button history = (Button) findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });
    }
}
