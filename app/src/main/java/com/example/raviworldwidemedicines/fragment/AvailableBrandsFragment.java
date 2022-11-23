package com.example.raviworldwidemedicines.fragment;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.AvailableBrandsDataAdapter;
import com.example.raviworldwidemedicines.model.AvailableBrandsDataModel;

import java.util.ArrayList;


public class AvailableBrandsFragment extends Fragment {

    private ArrayList<AvailableBrandsDataModel> availbleBrandslist=new ArrayList<>();
    private GridView gridView_available_brands_list;
    public AvailableBrandsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_available_brands, container, false);

        gridView_available_brands_list= (GridView) view.findViewById(R.id.grid_view_availble_brands);
        AvailableBrandsDataModel dataModel;
        for (int j=0;j<17;j++){
            dataModel= new AvailableBrandsDataModel(MainActivity.my_all_static_product_lists.get(j).getMedicine_image().getSrc());
            availbleBrandslist.add(dataModel);
        }
        AvailableBrandsDataAdapter availableBrandsDataAdapter= new AvailableBrandsDataAdapter( this.getContext(), availbleBrandslist);

        gridView_available_brands_list.setAdapter(availableBrandsDataAdapter);
        return view;
    }
}