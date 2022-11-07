package com.example.raviworldwidemedicines.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.raviworldwidemedicines.Controller.myController;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.DataAdapterOurProduct;
import com.example.raviworldwidemedicines.model.products.ProductResponse;
import com.example.raviworldwidemedicines.model.products.ProductResponseItem;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OurProductFragment extends Fragment {

    private ShowAllProductsFragment showAllProductsFragment;
    private List<ProductResponseItem> dataLists;
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

        gettingAllProducts();
        showAllProductsFragment= new ShowAllProductsFragment(-1);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "Item Clicked id : "+ adapterView.getItemIdAtPosition(i) +" . ", Toast.LENGTH_SHORT).show();
                 getParentFragmentManager().beginTransaction().replace (R.id.main_lays, showAllProductsFragment).commit();
            }
        });

        return view;
    }

    private void gettingAllProducts() {

        Call<List<ProductResponseItem>> call = myController.getInstance().getCategoryDetails_Api().getProducts();
        call.enqueue(new Callback<List<ProductResponseItem>>() {
            @Override
            public void onResponse(Call<List<ProductResponseItem>> call, Response<List<ProductResponseItem>> response) {
                dataLists= response.body();

                //   Sort by  product name
                Collections.sort(dataLists, new Comparator<ProductResponseItem>() {
                    @Override
                    public int compare(ProductResponseItem dataModel01, ProductResponseItem dataModel2) {
                        return dataModel01.getName().compareTo(dataModel2.getName());
                    }
                });

                DataAdapterOurProduct adapter= new DataAdapterOurProduct(getContext().getApplicationContext() , dataLists );
                gridView.setAdapter(adapter);

                Toast.makeText(getActivity(), " Products data  collected .  ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<ProductResponseItem>> call, Throwable t) {

            }

        });
    }

}