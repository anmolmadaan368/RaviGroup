package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.raviworldwidemedicines.model.DataModelOurProduct;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.DataAdapterOurProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OurProductFragment extends Fragment {

    private ShowAllProductsFragment showAllProductsFragment;
    public OurProductFragment() {
        // Required empty public constructor
    }

    public  GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_our_product, container, false);

        gridView= view.findViewById( R.id.idGViews);
        ArrayList<DataModelOurProduct> dataLists= new ArrayList<>();
        for (int i=0;i<9;i++){
            dataLists.add(new DataModelOurProduct(R.drawable.imgf_1,"image no : "+(i+1)));
        }

        //   Sort by  product name
        Collections.sort(dataLists, new Comparator<DataModelOurProduct>() {
            @Override
            public int compare(DataModelOurProduct dataModel01, DataModelOurProduct dataModel2) {
                return dataModel01.getItem_name().compareTo(dataModel2.getItem_name());
            }
        });
        DataAdapterOurProduct adapter= new DataAdapterOurProduct(getContext().getApplicationContext() , dataLists );
        gridView.setAdapter(adapter);
        showAllProductsFragment= new ShowAllProductsFragment();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "Item Clicked id : "+ adapterView.getItemIdAtPosition(i) +" . ", Toast.LENGTH_SHORT).show();
                 getParentFragmentManager().beginTransaction().replace (R.id.main_lays, showAllProductsFragment).commit();
            }
        });

        return view;
    }

}