package com.example.deguzman.pne;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import java.util.ArrayList;

public class Library extends AppCompatActivity {

    private Toolbar toolbar;

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    int[] font;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);



        title = new String[]{"Downy Mildew", "Late Blight", "Viral Diseases", "Bacterial spots", "Gray Mold", "Soft Rot"};
        description = new String[]{" Downy mildew (Bremia lactucae) is a common disease of lettuce in cooler growing environments, where temperatures are low and there are long periods of leaf wetness caused by overnight dew.",
                "Late blight is caused by the oomycete pathogen Phytophthora infestans.",
                "Viruses are intracellular (inside cells) pathogenic particles that infect other living organisms.",
                "Bacterial leaf spots are caused by the Xanthomonas and Pseudomonas families of bacteria. These bacteria overwinter in plant debris, but cannot survive for long in soil or water alone.",
                "A fungus that is pathogenic on many plants. This organism can survive on many hosts or on plant debris.",
                "The bacteria responsible for soft rot in lettuce is transferred by weather, insects, contaminated tools, infested plant debris and splashing water from rain and sprinklers."};
        icon = new int[]{R.drawable.downey_mildew, R.drawable.late_blight, R.drawable.yellow_leaf, R.drawable.bacterial_spots, R.drawable.gray_mold, R.drawable.soft_rot};


        listView = findViewById(R.id.listView);


        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            //do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
