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

import com.example.raviworldwidemedicines.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.CartDataAdapter;

import java.util.ArrayList;

public class ShowAllProductsFragment extends Fragment {

    private RecyclerView show_all_products_recycler_views;
    private android.widget.SearchView getSearched_product;
    private SearchView searchView;
    private TextView txt_no_data_found;
    private ArrayList<CartMultipleDataBinder> my_all_product_lists;
    private CartDataAdapter mydatas_adapters_list;
    private int []  item_imag_lists={R.drawable.imgf_5,R.drawable.imgf_3,R.drawable.imgf_2,R.drawable.imgf_1,R.drawable.imgf_4,R.drawable.buy,R.drawable.cart_icc,R.drawable.imgf_3,R.drawable.cart_icc,R.drawable.home_icon,R.drawable.ic_launcher_background,R.drawable.imgf_6,R.drawable.ic_launcher_background,R.drawable.imgf_7,R.drawable.imgf_8,R.drawable.loading,R.drawable.menu_icon,R.drawable.remove,R.drawable.user,R.drawable.search_icon,R.drawable.whatsapp };

    public ShowAllProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viw=inflater.inflate(R.layout.fragment_show_all_products, container, false);
        getSearched_product= (SearchView) viw.findViewById(R.id.searchviews);
        getSearched_product.setBackgroundResource(R.drawable.backgnd_while_rounded);
        txt_no_data_found= viw.findViewById(R.id.txt_no_data_exist);

        show_all_products_recycler_views= (RecyclerView) viw.findViewById(R.id.recycler_views_show_all_prodcts_recycler_views);
        searchView= viw.findViewById(R.id.searchviews);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        show_all_products_recycler_views.setLayoutManager(linearLayoutManager);


        CartMultipleDataBinder cartMultipleDataBinder;
        my_all_product_lists= new ArrayList<>();
        for (int i=0;i<item_imag_lists.length;i++){
            cartMultipleDataBinder= new CartMultipleDataBinder(item_imag_lists[i],"Product name is : "+ (i+1),"Salt name is :"+2 * (i+2)+" . ","Manufacturer Name : "+3 * (i+3) ,"Chemical name is "+ 2 * (i+3)+ ".");
            my_all_product_lists.add(cartMultipleDataBinder);
        }

        mydatas_adapters_list= new CartDataAdapter(my_all_product_lists, "ShowallProducts", R.layout.all_productsdetails_layouts, getParentFragmentManager(), new ClickListener() {
            @Override
            public void onPositionClicked(int Position) {

            }
        });


        show_all_products_recycler_views.setAdapter(mydatas_adapters_list);


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
        ArrayList<CartMultipleDataBinder> filteredList=new ArrayList<>();
        for ( CartMultipleDataBinder multipleDataBinder:my_all_product_lists ){
            if (multipleDataBinder.getProduct_name().toLowerCase().contains(s.toLowerCase())|| multipleDataBinder.getSalt_name().toLowerCase().contains(s.toLowerCase()) || multipleDataBinder.getChemical_amount().toLowerCase().contains( s.toLowerCase())){
                filteredList.add(multipleDataBinder);
            }

        }
        if (filteredList.isEmpty()){
            txt_no_data_found.setText(" no Data found ! ");
        }
        else {
            txt_no_data_found.setText("");
        }
        mydatas_adapters_list.setFilteredListToRecyclerViews(filteredList);
    }
}