package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.ShowAllProductDataAdapter;
import com.example.raviworldwidemedicines.model.SingleProductDetailsModel;

import java.util.ArrayList;

public class TopBrandsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_top_brands_list,container,false);

        RecyclerView recyclerView= view.findViewById(R.id.recycler_view_top_brands);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<SingleProductDetailsModel> mydatalists=new ArrayList<>();
//        mydatalists.add(new SingleProductDetailsModel("Abacavir / lamivudine (Epzicom®)","1000", R.drawable.medicine_image_3));
//        mydatalists.add(new SingleProductDetailsModel("Acyclovir","SII",R.drawable.medicine_image_4));
//        mydatalists.add(new SingleProductDetailsModel("Abacavir","Jhonson",R.drawable.medicine_image_5));
//        mydatalists.add(new SingleProductDetailsModel("Alendronate","Saturea",R.drawable.medicine_image_2));
//        mydatalists.add(new SingleProductDetailsModel("Acyclovir","Dolo",R.drawable.medicine_image_4));
//        mydatalists.add(new SingleProductDetailsModel("Abacavir","SII",R.drawable.medicine_image_5));
//        mydatalists.add(new SingleProductDetailsModel("Alendronate","SII ",R.drawable.medicine_image_2));

        for(int i=0;i<18;i++  ) {
            mydatalists.add(MainActivity.my_all_static_product_lists.get(i));
        }

        ShowAllProductDataAdapter myAdapters= new ShowAllProductDataAdapter(this.getContext(), mydatalists, "singleProductdetails",getParentFragmentManager());

        recyclerView.setAdapter(myAdapters);
        return view;
    }
}