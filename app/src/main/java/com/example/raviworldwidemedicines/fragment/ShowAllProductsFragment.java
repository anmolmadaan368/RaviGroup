package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.exampl.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.exampl.SingleProductDetailsFragment;
import com.example.raviworldwidemedicines.adapter.AllProductDataAdapter;

import java.util.ArrayList;

public class ShowAllProductsFragment extends Fragment {

    private GridView show_all_products_grid_view;
    private android.widget.SearchView getSearched_product;
    private SearchView searchView;
    private TextView txt_no_data_found;
    private ArrayList<CartMultipleDataBinder> my_all_product_lists;
    private AllProductDataAdapter mydatas_adapters_list;
    private int []  item_imag_lists={R.drawable.imgf_5,R.drawable.imgf_3,R.drawable.imgf_2,R.drawable.imgf_1,R.drawable.imgf_4,R.drawable.buy,R.drawable.cart_icc,R.drawable.imgf_3,R.drawable.cart_icc,R.drawable.home_icon,R.drawable.ic_launcher_background,R.drawable.imgf_6,R.drawable.ic_launcher_background,R.drawable.imgf_7,R.drawable.imgf_8,R.drawable.loading,R.drawable.menu_icon,R.drawable.remove,R.drawable.user,R.drawable.search_icon,R.drawable.whatsapp };

    public ShowAllProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viw=inflater.inflate(R.layout.fragment_show_all_products, container, false);
        txt_no_data_found= viw.findViewById(R.id.txt_no_data_exist);

        show_all_products_grid_view= (GridView) viw.findViewById(R.id.grid_views_show_all_prodcts_grid_viws);
        searchView= viw.findViewById(R.id.searchviews);
        searchView.setBackgroundResource(R.drawable.backgnd_while_rounded);

        CartMultipleDataBinder cartMultipleDataBinder;
        my_all_product_lists= new ArrayList<>();
        for (int i=0;i<item_imag_lists.length;i++){
            cartMultipleDataBinder= new CartMultipleDataBinder(item_imag_lists[i],"dfgf","dfd","dfdsfsd","dfsdf");
            my_all_product_lists.add(cartMultipleDataBinder);
        }

        mydatas_adapters_list= new AllProductDataAdapter(getContext().getApplicationContext(),my_all_product_lists);


        show_all_products_grid_view.setAdapter(mydatas_adapters_list);
        show_all_products_grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                Log.d("My Products Details is heree ", "onItemClick: "+ my_all_product_lists.get(i));
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays,    new SingleProductDetailsFragment(my_all_product_lists.get(i))).commit();
            }
        });

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
//        mydatas_adapters_list.setFilteredListToRecyclerViews(filteredList);
    }
}