package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.model.DynamicRvModel;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.DynamicDataAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServicesFragment extends Fragment {
    public ServicesFragment() {
        // Required empty public constructor
    }

    public RecyclerView recyclerView;
    public TextView servicesContents;
    private List<DynamicRvModel> itemlists;
    private SearchView searchViews;
    private DynamicDataAdapter dynamicDataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        itemlists = new ArrayList<>();
        itemlists.add(new DynamicRvModel("Validated cold chain shipment", R.drawable.imgf_1 ,"According to international drug guidelines (such as FDA 21 CFR part 211.142), we always transport and store drugs & vaccines within a validated temperature range at every point in the supply chain efficiently and seamlessly."));
        itemlists.add(new DynamicRvModel("Name Patient Supply", R.drawable.imgf_2 , "We supply rare drugs to select patients and physicians who have submitted requisite documents to access rare drugs yet are not approved for marketing by respective health authorities of different countries."));
        itemlists.add(new DynamicRvModel("Pharmaceutical Contract Manufacturing", R.drawable.imgf_3 , "We offer manufacturing of specific drugs in bulk, conduction of stability studies, trial materials, formal stability batches etc for custom enterprise orders.\n "));
        itemlists.add(new DynamicRvModel("Generic & Branded medicines", R.drawable.imgf_4, "We boast a wide network of trustworthy FDA-approved generic and branded drug manufacturers across the globe."));
        itemlists.add(new DynamicRvModel("RLD/Innovator Sourcing", R.drawable.imgf_5, "With 30+ years of expertise in networking with international drug wholesale partners, we can source/supply RLDs as per requirement (specific batches/expiry) for global markets of the Americas, Oceania, Europe, China, etc."));
        itemlists.add(new DynamicRvModel("C and F Agent", R.drawable.imgf_6 , "Our vast network of distributors, chemists, hospitals, pharmacies and world-class inventory storage facilities help in bridging the gap between owners of medicines/medicinal equipment and owners of transport & logistics."));
        recyclerView = (RecyclerView) view.findViewById(R.id.myservices_recyclerViews);
        TextView tvServicesContents = (TextView) view.findViewById(R.id.servicesDescp);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        dynamicDataAdapter = new DynamicDataAdapter(itemlists, tvServicesContents, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
            }
        });
        recyclerView.setAdapter(dynamicDataAdapter);

//        item = new ArrayList<>();

//        servicesContents= container.findViewById(R.id.servicesDesc  );
//        item.add(new DynamicRvModel("This is the service of one ",-1));
        searchViews = view.findViewById(R.id.searchviews);
        searchViews.clearFocus();
        searchViews.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });
        searchViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }

    private void filterList(String s) {
        ArrayList<DynamicRvModel> filteredList = new ArrayList<>();
        for (DynamicRvModel rvModel : itemlists) {
            if (rvModel.getItemname().toLowerCase().contains(s)) {
                DynamicRvModel rvModel1 = new DynamicRvModel(rvModel.getItemname(), rvModel.getImages(), rvModel.getServices_Contents());
                filteredList.add(rvModel1);
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(getContext(), " no data found . ", Toast.LENGTH_SHORT).show();
        } else {
            dynamicDataAdapter.setFilteredListtoRecyclerViews(filteredList);
        }
    }

}