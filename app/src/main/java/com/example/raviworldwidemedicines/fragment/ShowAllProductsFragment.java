package com.example.raviworldwidemedicines.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.Controller.myController;
import com.example.raviworldwidemedicines.adapter.TopBrandsDataAdapter;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.TopBrandsItemDetails;
import com.example.raviworldwidemedicines.model.products.ProductResponseItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAllProductsFragment extends Fragment {

    private RecyclerView recycler_views_data_lists;
    private android.widget.SearchView getSearched_product;
    private SearchView searchView;
    private TextView txt_no_data_found;
    private int category_id;
    private ArrayList<TopBrandsItemDetails> my_all_product_lists;
    private TopBrandsDataAdapter mydatas_adapters_list;
    private int []  item_imag_lists={R.drawable.imgf_5,R.drawable.imgf_3,R.drawable.imgf_2,R.drawable.imgf_1,R.drawable.imgf_4,R.drawable.buy,R.drawable.cart_icc,R.drawable.imgf_3,R.drawable.cart_icc,R.drawable.home_icon,R.drawable.ic_launcher_background,R.drawable.imgf_6,R.drawable.ic_launcher_background,R.drawable.imgf_7,R.drawable.imgf_8, com.denzcoskun.imageslider.R.drawable.loading,R.drawable.menu_icon,R.drawable.remove,R.drawable.user,R.drawable.search_icon,R.drawable.whatsapp };

    public ShowAllProductsFragment (int category_id) {
        // Required empty public constructor
        this.category_id=category_id;
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

        if(category_id  == -1) {

            my_all_product_lists = new ArrayList<>();
            for (int i = 0; i < item_imag_lists.length; i++) {
                topBrandsItemDetails = new TopBrandsItemDetails("Dettots", "02 mar, 2014", "270", "SII", item_imag_lists[i], 14);
                my_all_product_lists.add(topBrandsItemDetails);
            }

            mydatas_adapters_list= new TopBrandsDataAdapter(getContext(),my_all_product_lists,"singleProductdetails",getParentFragmentManager());
            recycler_views_data_lists.setAdapter(mydatas_adapters_list);


        }
        else {

            Call<List<ProductResponseItem>> call= myController.getInstance().getCategoryDetails_Api().getProducts();
            call.enqueue(new Callback<List<ProductResponseItem>>() {
                @Override
                public void onResponse(Call<List<ProductResponseItem>> call, Response<List<ProductResponseItem>> response) {
                    if(response.isSuccessful() && response!=null ){
                        List<ProductResponseItem>   responseItem= response.body();
                        for (int i=0; i<responseItem.size();i++ ) {
                            int specificProductCategoryId= responseItem.get(1).getId();
                            if(category_id== specificProductCategoryId){

                                my_all_product_lists.add(new TopBrandsItemDetails( responseItem.get(1).getName(), responseItem.get(2).getId()+"","","",-1,-1));
                            }
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), " Category Details Product Product's  response is NULL "+ response, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onResponse:  Category Details Product Product's  response is "+ response+ ".");
                        my_all_product_lists= new ArrayList<>();
                    }

                    if(my_all_product_lists.size()==0){
                        for (int i = 0; i < item_imag_lists.length; i++) {
                            TopBrandsItemDetails topBrandsItemDetails = new TopBrandsItemDetails("Dettots", "02 mar, 2014", "270", "SII", item_imag_lists[i], 14);
                            my_all_product_lists.add(topBrandsItemDetails);
                        }
                    }
                    mydatas_adapters_list= new TopBrandsDataAdapter(getContext(),my_all_product_lists,"singleProductdetails",getParentFragmentManager());
                    recycler_views_data_lists.setAdapter(mydatas_adapters_list);

                }

                @Override
                public void onFailure(Call<List<ProductResponseItem>> call, Throwable t) {
                    Toast.makeText(getActivity(), " onFailure: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onFailure: "+ t.getMessage());
                }
            });

        }

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