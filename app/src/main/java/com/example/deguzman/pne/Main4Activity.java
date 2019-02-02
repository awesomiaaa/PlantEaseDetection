package com.example.deguzman.pne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main4Activity extends Fragment {
    TextView tab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment2, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        final String diagnosis = intent.getStringExtra(ListViewAdapter.KEY_DIAGNOSIS);


        tab = (TextView) view.findViewById(R.id.textView);
        tab.setText(diagnosis);
        //   tab.setText(diagnosis);

        return view;
    }
}
