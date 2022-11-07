package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.LicenceAdapter;
import com.example.raviworldwidemedicines.model.ModelLicence;

import java.util.ArrayList;


public class LicenseFragment extends Fragment {

    public SearchView sviews;

    RecyclerView license_recycler_view;
    ArrayList<ModelLicence>licencedemo_second;

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

        license_recycler_view = view.findViewById(R.id.license_recycler_view);
        license_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
       licencedemo_second = new ArrayList<>();

       ModelLicence ob1 = new ModelLicence(R.drawable.certfct_cii);
       licencedemo_second.add(ob1);
        ModelLicence ob2 = new ModelLicence(R.drawable.certfct_fssai);
        licencedemo_second.add(ob2);
        ModelLicence ob3 = new ModelLicence(R.drawable.certfct_gdp);
        licencedemo_second.add(ob3);
        ModelLicence ob4 = new ModelLicence(R.drawable.certfct_iso);
        licencedemo_second.add(ob4);
        ModelLicence ob5 = new ModelLicence(R.drawable.certfct_pharmexcil);
        licencedemo_second.add(ob5);
        ModelLicence ob6 = new ModelLicence(R.drawable.certfct_msme);
        licencedemo_second.add(ob6);

        license_recycler_view.setAdapter(new LicenceAdapter(licencedemo_second));

        return  view;

    }
}