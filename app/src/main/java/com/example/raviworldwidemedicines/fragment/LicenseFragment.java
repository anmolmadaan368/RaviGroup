package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SearchView;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.LicenseAdapters;
import com.example.raviworldwidemedicines.model.SingleProductDetailsModel;

import java.util.ArrayList;
import java.util.List;


public class LicenseFragment extends Fragment {

    public SearchView sviews;
    public GridView license_grid_view;

    public LicenseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_license, container, false);
//        sviews = (SearchView) view.findViewById(R.id.searchviews);
//        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);
        license_grid_view = (GridView) view.findViewById(R.id.license_views);
//        sviews.setQueryHint("Hints ");
//  Making whole search view Clickable here ...
//        sviews.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sviews.setIconified(false);
//            }
//        });

        ArrayList<String> myLists= new ArrayList<>();
        myLists.add("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/certfct_logo3.png");
        myLists.add("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/certfct_logo2.png" );
        myLists.add("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/certfct_logo1.png");
        myLists.add("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/certfct_logo6.png");
        myLists.add("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/certfct_logo4.png");
        myLists.add("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/certfct_logo5.png");
        LicenseAdapters licenseAdapter = new LicenseAdapters(this.getContext(), myLists);

        license_grid_view.setAdapter(licenseAdapter);

        return view;

    }
}