package com.example.deguzman.pne;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.swipe.SwipeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AddingPlant extends AppCompatActivity {
    private static final String URL_DATA = "http://192.168.1.10:8080/Plant_Lists/?format=json";

    final Context context = this;

    private SwipeLayout sample1, sample2, sample3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_plant);



        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.fab) ;
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddingPlant.this, AddPlantInforActivity.class);
                startActivity(i);
            }
        });

//        SwipeLayout swipeLayout = (SwipeLayout)findViewById(R.id.godfather);
//        swipeLayout.setDragEdge(SwipeLayout.DragEdge.Bottom); // Set in XML

        //sample1


        //sample2

        sample2 = (SwipeLayout) findViewById(R.id.sample2);
        sample2.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample2.addDrag(SwipeLayout.DragEdge.Right, sample2.findViewWithTag("Bottom2"));
//        sample2.setShowMode(SwipeLayout.ShowMode.PullOut);
        sample2.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddingPlant.this, "Edit", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddingPlant.this, AddPlantInforActivity.class);
                startActivity(i);
            }
        });

        sample2.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddingPlant.this, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample2.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddingPlant.this, "Scan", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddingPlant.this, ScanActivity.class);
                startActivity(i);
            }
        });

        sample2.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddingPlant.this, "Click on surface", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog1);

                TextView title = (TextView) dialog.findViewById(R.id.title);
                title.setText("A1");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.input_name);
                text.setText("Lettuce");

                dialog.show();
            }
        });

    }


    /*
    Color transition method.
     */
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;

        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;

        return (int) ((startA + (int) (fraction * (endA - startA))) << 24) |
                (int) ((startR + (int) (fraction * (endR - startR))) << 16) |
                (int) ((startG + (int) (fraction * (endG - startG))) << 8) |
                (int) ((startB + (int) (fraction * (endB - startB))));
    }


}