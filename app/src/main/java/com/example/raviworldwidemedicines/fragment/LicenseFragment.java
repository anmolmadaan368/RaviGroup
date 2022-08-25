package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.raviworldwidemedicines.R;


public class LicenseFragment extends Fragment {

    public SearchView sviews;

    public LicenseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_license, container, false);
        sviews = (SearchView) view.findViewById(R.id.searchviews);
        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);

//        sviews.setQueryHint("Hints ");
//  Making whole search view Clickable here ...
        sviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sviews.setIconified(false);
            }
        });

        return  view;

    }
}