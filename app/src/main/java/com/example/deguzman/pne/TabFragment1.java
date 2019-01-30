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

    private static final String URL_DATA = "http://192.168.1.10:8080/Scans/?format=json";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HistoryList> historyLists;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment1, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);

        final String libdisease = intent.getStringExtra(ListViewAdapter.KEY_DISEASE);


        tab = (TextView) view.findViewById(R.id.textView2);

        tab.setText(disease);
        tab.setText(libdisease);
        return view;
    }

}
