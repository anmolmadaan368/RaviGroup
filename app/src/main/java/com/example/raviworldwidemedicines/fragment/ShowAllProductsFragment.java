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

import com.example.raviworldwidemedicines.adapter.topBrandsRecyclerviewDataListAdapters;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.TopBrandsItemDetails;

import java.util.ArrayList;

public class ShowAllProductsFragment extends Fragment {

    private RecyclerView recycler_views_data_lists;
    private android.widget.SearchView getSearched_product;
    private SearchView searchView;
    private TextView txt_no_data_found;
    private ArrayList<TopBrandsItemDetails> my_all_product_lists;
    private topBrandsRecyclerviewDataListAdapters mydatas_adapters_list;
    private int []  item_imag_lists={R.drawable.imgf_5,R.drawable.imgf_3,R.drawable.imgf_2,R.drawable.imgf_1,R.drawable.imgf_4,R.drawable.buy,R.drawable.cart_icc,R.drawable.imgf_3,R.drawable.cart_icc,R.drawable.home_icon,R.drawable.ic_launcher_background,R.drawable.imgf_6,R.drawable.ic_launcher_background,R.drawable.imgf_7,R.drawable.imgf_8, com.denzcoskun.imageslider.R.drawable.loading,R.drawable.menu_icon,R.drawable.remove,R.drawable.user,R.drawable.search_icon,R.drawable.whatsapp };

    public ShowAllProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viw=inflater.inflate(R.layout.fragment_show_all_products, container, false);
        txt_no_data_found= viw.findViewById(R.id.txt_no_data_exist);

        recycler_views_data_lists= (RecyclerView) viw.findViewById(R.id.recycler_view_item_lists);
        searchView= viw.findViewById(R.id.searchviews);
        searchView.setBackgroundResource(R.drawable.backgnd_while_rounded);

        LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(this.getContext());
        recycler_views_data_lists.setLayoutManager(linearLayoutManager);
        TopBrandsItemDetails topBrandsItemDetails;
        my_all_product_lists= new ArrayList<>();
        for (int i=0;i<item_imag_lists.length;i++){
            topBrandsItemDetails= new TopBrandsItemDetails("Dettots","02 mar, 2014","270","SII",item_imag_lists[i],14);
            my_all_product_lists.add(topBrandsItemDetails);
        }

        mydatas_adapters_list= new topBrandsRecyclerviewDataListAdapters(this.getContext().getApplicationContext(),my_all_product_lists,"singleProductdetails",getParentFragmentManager());


        recycler_views_data_lists.setAdapter(mydatas_adapters_list);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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






        return viw;

    }

    private void filterList(String s) {
        ArrayList<TopBrandsItemDetails> filteredList=new ArrayList<>();
        for ( TopBrandsItemDetails topBrandsItemDetails:my_all_product_lists ){
            if (topBrandsItemDetails.getMedicines_name().toLowerCase().contains(s.toLowerCase())|| topBrandsItemDetails.getManufacturer_name().toLowerCase().contains(s.toLowerCase())){
                filteredList.add(topBrandsItemDetails);
            }

        }
        if (filteredList.isEmpty()){
            txt_no_data_found.setText(" no Data found ! ");
        }
        else {
            txt_no_data_found.setText("");
        }
//        mydatas_adapters_list.setFilteredListToRecyclerViews(filteredList);
    }
}