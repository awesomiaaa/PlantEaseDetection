package com.example.deguzman.pne;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class AddPlantActivity extends AppCompatActivity {
    private static final String URL_DATA = "http://172.20.10.5:8080/Plant_Lists/?format=json";
    private PlayersDataAdapter mAdapter;
    SwipeController swipeController = null;
    final Context context = this;

    private SwipeLayout sample1, sample2, sample3;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<AddPlantList> addPlantLists;

    private FloatingActionMenu fam;
    private com.github.clans.fab.FloatingActionButton fabmulticrop, fabunicrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

    /*    FloatingActionButton add = (FloatingActionButton) findViewById(R.id.fab) ;
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddPlantActivity.this, AddPlantInforActivity.class);
                startActivity(i);
            }
        });*/

//        SwipeLayout swipeLayout = (SwipeLayout)findViewById(R.id.godfather);
//        swipeLayout.setDragEdge(SwipeLayout.DragEdge.Bottom); // Set in XML

        //sample1


        //sample2

    /*    sample2 = (SwipeLayout) findViewById(R.id.sample2);
        sample2.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample2.addDrag(SwipeLayout.DragEdge.Right, sample2.findViewWithTag("Bottom2"));
//        sample2.setShowMode(SwipeLayout.ShowMode.PullOut);
        sample2.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddPlantActivity.this, AddPlantInforActivity.class);
                startActivity(i);
            }
        });

        sample2.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample2.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Scan", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddPlantActivity.this, ScanActivity.class);
                startActivity(i);
            }
        });

        sample2.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog1);

                TextView title = (TextView) dialog.findViewById(R.id.title);
                title.setText("A1");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.input_name);
                text.setText("Lettuce");

                dialog.show();
            }
        });*/
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addPlantLists = new ArrayList<>();

        System.out.println(recyclerView);
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                addPlantLists.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());

            }
            @Override
            public void onLeftClicked(int position) {
                Toast.makeText(AddPlantActivity.this, "Scan", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddPlantActivity.this, AddPlantInforActivity.class);
                startActivity(i);

            }

        });
        recyclerView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(AddPlantActivity.this,"Scan",Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddPlantActivity.this, ScanActivity.class);
                startActivity(i);
            }
        });
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

        loadUrlData();

        fabmulticrop = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab2);
        fabunicrop = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab1);
        fam = (FloatingActionMenu) findViewById(R.id.fab_menu);

        //handling menu status (open or close)
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                  //  showToast("Menu is opened");
                } else {
                 //   showToast("Menu is closed");
                }
            }
        });

        //handling each floating action button clicked
        fabmulticrop.setOnClickListener(onButtonClick());
        fabunicrop.setOnClickListener(onButtonClick());

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fam.isOpened()) {
                    fam.close(true);
                }
            }
        });
    }

    private View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == fabmulticrop) {
                    showToast("Multicrop Button clicked");
                    Intent i = new Intent(AddPlantActivity.this, AddPlantPlot.class);
                    startActivity(i);
                } else if (view == fabunicrop) {
                    showToast("Unicrop Button clicked");
                    Intent i = new Intent(AddPlantActivity.this, AddPlantInforActivity.class);
                    startActivity(i);
                }
                fam.close(true);
            }
        };
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /*
    Color transition method.
     */
  /*  public Object evaluate(float fraction, Object startValue, Object endValue) {
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
    }*/



    private void loadUrlData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);


                    JSONArray array = jsonObject.getJSONArray("results");

                  //  for (int i = 0; i < array.length(); i++) {

                   //     JSONObject jo = array.getJSONObject(array);
                  //      JSONArray ar = jo.getJSONArray("scan_details");
                        for (int l = 0; l < array.length(); l++) {
                            JSONObject rec = array.getJSONObject(l);
                            AddPlantList addplantlist = new AddPlantList(
                                    rec.getString("id"),
                                    rec.getString("plant_name"),
                                    rec.getString("specific_plant"),
                                    rec.getString("plant_width"),
                                    rec.getString("plot_size"),
                                    rec.getString("plant_distance"));
                            addPlantLists.add(addplantlist);
                            System.out.println(rec.optString("plant_name"));


                       // }
                    }



                    adapter = new AddPlantListAdapter(addPlantLists, getApplicationContext());
                 //   mAdapter = new PlayersDataAdapter(addPlantLists, getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AddPlantActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        }


}