package com.example.deguzman.pne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class AddPlantView extends AppCompatActivity {

    public static TextView plantname, spec_plant, plant_distance, plot_size, plot_width;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_view);

        plantname = (TextView) findViewById(R.id.plant_name);
        spec_plant = (TextView) findViewById(R.id.spec_plant);
        plant_distance = (TextView) findViewById(R.id.plant_distance);
        plot_size = (TextView) findViewById(R.id.plot_size);
        plot_width = (TextView) findViewById(R.id.plot_width);

        Intent intent = getIntent();
        //    final String plant_type = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_TYPE);
        final String plantn = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_NAME);
        final String specp = intent.getStringExtra(AddPlantListAdapter.KEY_SPEC_PLANT);
        final String plantd = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_DIST);
        final String plots = intent.getStringExtra(AddPlantListAdapter.KEY_PLOT_SIZE);
        final String plotw = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_WIDTH);
        final String id = intent.getStringExtra(AddPlantListAdapter.KEY_ID);

        plantname.setText("Name: " + plantn);
        spec_plant.setText("Specific Plant: " + specp);
        plant_distance.setText("Plant Distance: " + plantd);
        plot_size.setText("Plot Size: " + plots);
        plot_width.setText("Plot Width: " + plotw);

        System.out.println(id);

        Button start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              //  Toast.makeText(AddPlantView.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
                plantactivate plantlister = new plantactivate();
                plantlister.execute();
                activate process = new activate();
                process.execute();


                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://192.168.43.173:8080/start", new AsyncHttpResponseHandler() {


                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
/*
                        onDisplay process = new onDisplay();
                        process.execute();
*/
                        /*deactivate deact = new deactivate();
                        deact.execute();*/
                  /*      System.out.println("s");
                        Intent i = new Intent(AddPlantView.this, ScanActivity.class);
                        startActivity(i);*/
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }


                });/*
                System.out.println("done");*/

                Intent i = new Intent(AddPlantView.this, ScanActivity.class);
                startActivity(i);
            }
        });


    }
}
