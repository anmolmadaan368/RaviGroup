package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.topBrandsRecyclerviewDataListAdapters;
import com.example.raviworldwidemedicines.model.TopBrandsItemDetails;

import java.util.ArrayList;

public class TopBrandsListFragment extends Fragment {

    public TopBrandsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_top_brands_list,container,false);

        RecyclerView recyclerView= view.findViewById(R.id.recycler_view_top_brands);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<TopBrandsItemDetails> mydatalists=new ArrayList<>();
        mydatalists.add(new TopBrandsItemDetails("Abacavir / lamivudine (Epzicom®)","02 feb,2024","1000","Cipla",R.drawable.medicine_image_3,24));
        mydatalists.add(new TopBrandsItemDetails("Acyclovir","04 mar,2025","2000","SII",R.drawable.medicine_image_4,24));
        mydatalists.add(new TopBrandsItemDetails("Abacavir","07 may,2024","1187","Jhonson",R.drawable.medicine_image_5,23));
        mydatalists.add(new TopBrandsItemDetails("Alendronate","06 sep,2026","2227","Saturea",R.drawable.medicine_image_2,7));
        mydatalists.add(new TopBrandsItemDetails("Acyclovir","04 mar,2025","2000","Dolo",R.drawable.medicine_image_4,24));
        mydatalists.add(new TopBrandsItemDetails("Abacavir","07 may,2024","1187","SII",R.drawable.medicine_image_5,23));
        mydatalists.add(new TopBrandsItemDetails("Alendronate","06 sep,2026","2227","SII ",R.drawable.medicine_image_2,9));


        topBrandsRecyclerviewDataListAdapters myAdapters= new topBrandsRecyclerviewDataListAdapters(this.getContext(), mydatalists, "singleProductdetail",getParentFragmentManager());

        recyclerView.setAdapter(myAdapters);
        return view;
    }
}