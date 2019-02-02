package com.example.deguzman.pne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signin = (Button) findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
