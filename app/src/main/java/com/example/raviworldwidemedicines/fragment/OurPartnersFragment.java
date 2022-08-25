package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raviworldwidemedicines.OurPartnerDataModel;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.OurPartnerDataAdapter;

import java.util.ArrayList;

public class OurPartnersFragment extends Fragment {

    public RecyclerView recycler_views_our_product;
    public OurPartnersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view= inflater.inflate(R.layout.fragment_our_partners, container, false);

        recycler_views_our_product= (RecyclerView)  view.findViewById(R.id.recycler_views_our_partners);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recycler_views_our_product.setLayoutManager(linearLayoutManager);
        ArrayList<OurPartnerDataModel> our_partner_lists=new ArrayList<>();
        OurPartnerDataModel dataModel;
        for (int i=0;i<39;i++) {
            dataModel = new OurPartnerDataModel(R.drawable.cart_icc, "Partner : " + i, "CEO:  " + (i + 1), " " + (i + 1) + " This is Nice .  ");
            our_partner_lists.add(dataModel);
        }

        OurPartnerDataAdapter dataAdapter=new OurPartnerDataAdapter(our_partner_lists);
        recycler_views_our_product.setAdapter( dataAdapter);

        return view;
    }
}