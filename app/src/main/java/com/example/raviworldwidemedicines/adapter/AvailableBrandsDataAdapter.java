package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.AvailableBrandsDataModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AvailableBrandsDataAdapter extends ArrayAdapter<AvailableBrandsDataModel> {

    private Context context;
    private ArrayList<AvailableBrandsDataModel> my_availble_brands_lists;

    public AvailableBrandsDataAdapter(@NonNull Context context,@NonNull ArrayList<AvailableBrandsDataModel> availableBrandsDataModelLists) {
        super(context, 0, availableBrandsDataModelLists);
        this.context= context;
        this.my_availble_brands_lists= availableBrandsDataModelLists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= convertView;

        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_available_brands_layout,parent,false);
        }
        AvailableBrandsDataModel brandsDataModel= my_availble_brands_lists.get(position);

        ImageView top_available_brands_images= view.findViewById(R.id.availble_brands_images);
        top_available_brands_images.setImageResource(brandsDataModel.getBrand_images());
        return view;
    }
}
