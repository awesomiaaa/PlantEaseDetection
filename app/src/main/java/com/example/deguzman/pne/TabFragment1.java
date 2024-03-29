package com.example.deguzman.pne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TabFragment1 extends Fragment {
    TextView tab;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HistoryList> historyLists;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment1, container, false);

        Intent intent = getActivity().getIntent();
        String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);

        String libdisease = intent.getStringExtra(ListViewAdapter.KEY_DISEASE);


        tab = (TextView) view.findViewById(R.id.textView2);


        tab.setText(libdisease);
    if(condition.equalsIgnoreCase("unhealthy")) {
        if (disease.equalsIgnoreCase("Leaf Spot") || disease.equalsIgnoreCase("spot")) {
            tab.setText("Leaf Spot");
        } else if (disease.equalsIgnoreCase("Powdery Mildew") || disease.equalsIgnoreCase("mildew")) {
            tab.setText("Powdery Mildew");
        } else if (disease.equalsIgnoreCase("Anthracnose") || disease.equalsIgnoreCase("antracnose' ")) {
            tab.setText("Anthracnose");
        } else if (disease.equalsIgnoreCase("Late Blight ") || disease.equalsIgnoreCase("lateblight")) {
            tab.setText("Late Blight");
        } else if (disease.equalsIgnoreCase("not a plant") || disease.equalsIgnoreCase("object")) {
            tab.setText("Not a Plant");
        }
    }
    else if(condition.equalsIgnoreCase("object")) {
            tab.setText("Not a Plant");
        }
    else if(condition.equalsIgnoreCase("healthy") || disease.equalsIgnoreCase("HEALTHY")){
            tab.setText("No Disease Detected");
        }




        return view;
    }

}
