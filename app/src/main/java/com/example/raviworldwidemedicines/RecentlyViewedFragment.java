package com.example.raviworldwidemedicines;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raviworldwidemedicines.adapter.RecentlyViewAdapter;

import java.util.ArrayList;

public class RecentlyViewedFragment extends Fragment {

    public ArrayList<CartMultipleDataBinder> recently_viewed_list= new ArrayList<>();
    private RecyclerView recyclerView_recently_viewed;
    public RecentlyViewedFragment( ArrayList<CartMultipleDataBinder> all_recently_lists) {
        // Required empty public constructor
        this.recently_viewed_list=all_recently_lists;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recently_viewed, container, false);

        recyclerView_recently_viewed= view.findViewById(R.id.recycler_viewded_data_lists);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView_recently_viewed.setLayoutManager(linearLayoutManager);
        int[] medicines_images = {R.drawable.imgf_1, R.drawable.imgf_2, R.drawable.imgf_3, R.drawable.imgf_5};
        String[] manufacturer_list = {"CELON LABORATORIES LTD", "GLENMARK PHARMACEUTICALS LTD", "MYLAN PHARMACEUTICALS PVT LTD", "CELON LABORATORIES LTD"};
        String[] salt_comp_name_list = {"ABEVMY 100MG INJECTION", "BEVACIZUMAB", "ABIRATERONE ACETATE", "ENZALUTAMIDE"};
        String[] product_name = {"ABIRAPRO 250MG TABLET", "BDENZA 40MG CAPSULE", "BDPARIB 200MG TABLET", "ABEVMY 100MG INJECTION"};
        String[] comp_amount = {"1 VIAL(s) OF 4ML", "20 TABLET(s) IN A BOTTLE", "8 CAPSULE(s) IN A STRIP", "60 TABLET(s) IN A BOTTLE"};

        CartMultipleDataBinder databinder;
        for (int i=0;i<medicines_images.length;i++){
            databinder=new CartMultipleDataBinder(medicines_images[i],product_name[i],salt_comp_name_list[i],manufacturer_list[i],comp_amount[i]);
            recently_viewed_list.add(databinder);
        }
        RecentlyViewAdapter myadapter= new RecentlyViewAdapter(recently_viewed_list, getParentFragmentManager() ,new ClickListener() {
            @Override
            public void onPositionClicked(int Position) {

            }
        });
        recyclerView_recently_viewed.setAdapter(myadapter);

        return view;



    }
}