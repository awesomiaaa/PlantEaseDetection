package com.example.deguzman.pne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddPlantView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_view);

        TextView plantname = (TextView) findViewById(R.id.plant_name);
        TextView spec_plant = (TextView) findViewById(R.id.spec_plant);
        TextView plant_distance = (TextView) findViewById(R.id.plant_distance);
        TextView plot_size = (TextView) findViewById(R.id.plot_size);
        TextView plot_width = (TextView) findViewById(R.id.plot_width);

        Intent intent = getIntent();
        //    final String plant_type = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_TYPE);
        final String plantn = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_NAME);
        final String specp = intent.getStringExtra(AddPlantListAdapter.KEY_SPEC_PLANT);
        final String plantd = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_DIST);
        final String plots = intent.getStringExtra(AddPlantListAdapter.KEY_PLOT_SIZE);
        final String plotw = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_WIDTH);

        plantname.setText("Name: " + plantn);
        spec_plant.setText("Specific Plant: " + specp);
        plant_distance.setText("Plant Distance: " + plantd);
        plot_size.setText("Plot Size: " + plots);
        plot_width.setText("Plot Width: " + plotw);

        Button start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              //  Toast.makeText(AddPlantView.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddPlantView.this, ScanActivity.class);
                startActivity(i);
            }
        });
    }
}
