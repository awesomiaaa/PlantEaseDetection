package com.example.deguzman.pne;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;
import static com.loopj.android.http.AsyncHttpClient.LOG_TAG;

public class ScanActivity extends AppCompatActivity {

    final Context context = this;
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
    private static final String URL_DATA = "http://172.20.10.5:8080/Scans/?format=json";
    public static ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<DevelopersList> developersLists;

    private SwipeRefreshLayout mySwipeRefreshLayout;

    private JSONObject jo;

    Button click;
    public static TextView data, outputPost, loc, plant_no;



    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        FloatingActionButton sum = (FloatingActionButton) findViewById(R.id.summary);
        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_scan);

                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                *//*recyclerView.setLayoutManager(new LinearLayoutManager(this));*//*
                GridLayoutManager gridLayoutManager = new GridLayoutManager(ScanActivity.this, 1);
                recyclerView.setLayoutManager(gridLayoutManager);
                developersLists = new ArrayList<>();
//                TextView title = (TextView) dialog.findViewById(R.id.title);
//                title.setText("A1");
//
//                // set the custom dialog components - text, image and button
//                TextView text = (TextView) dialog.findViewById(R.id.input_name);
//                text.setText("Lettuce");
                loadUrlData();
                dialog.show();*/

                startActivity(new Intent(ScanActivity.this, Summary.class));
            }

        });

       /* Button a1 = (Button) findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScanActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });*/

    /*    click = (Button) findViewById(R.id.fetchdata);
        data=(TextView) findViewById(R.id.fetchdata);
        outputPost = (TextView) findViewById(R.id.textView);
        click.setOnClickListener(new View.OnClickListener()
                                 {
                                     @Override
                                     public  void onClick(View view){
                                         fetchData process = new fetchData();
                                         process.execute();
                                     }
                                 }
        );*/




                        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                        recyclerView.setHasFixedSize(true);
                        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(ScanActivity.this, 2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        developersLists = new ArrayList<>();
                        loadUrlData();

    }


    private void loadUrlData() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                try {

                    JSONObject jsonObject = new JSONObject(response);


                    JSONArray array = jsonObject.getJSONArray("results");

                    jo = array.getJSONObject(array.length()-1);

/*
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jo1 = array.getJSONObject(i);
             */           /*
                        JSONArray ar = jo.getJSONArray("scan_details");*/

/*
                        JSONArray ar = jo.getJSONArray("id");
                        JSONObject tot_obj = ar.getJSONObject(array.length()-1);*/

                    JSONArray a = jo.getJSONArray("scan_details");

                    for (int l = 0; l < a.length(); l++) {
                        JSONObject rec = a.getJSONObject(l);

                        DevelopersList developers = new DevelopersList(
                                rec.getString("condition"),
                                jo.getBoolean("status"),
                                jo.getString("id"),
                                rec.getString("plant_no"),
                                rec.getString("disease"),
                                rec.getString("diagnosis"),
                                rec.getString("model_pic"));



                        developersLists.add(developers);
                        System.out.println( rec.getString("condition"));

                        if(jo.optString("status").equals("false")){
                            System.out.println("Unhealthy");


                        }
                        if(rec.optString("condition").equalsIgnoreCase("healthy")){
                            System.out.println("Healthy");
                            System.out.println(rec.optString("plant_no"));
                        }
                    }


                    /*}*/



                    adapter = new DevelopersAdapter(developersLists, getApplicationContext());

                    recyclerView.setAdapter(adapter);

//                    if(jo.optString("status").equals("false")) {
                        progressDialog.dismiss();
                  /*  }else {
                        System.out.println(jo.optString("status"));
                      *//*  Intent intent = getIntent();
                        finish();
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);

*//*

                    }
*/


                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ScanActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}


