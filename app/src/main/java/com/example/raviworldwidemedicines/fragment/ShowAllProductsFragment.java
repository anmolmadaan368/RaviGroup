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
import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.adapter.ShowAllProductDataAdapter;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.AllProductsByCategory.GetAllProductOfCategories;
import com.example.raviworldwidemedicines.model.SingleProductDetailsModel;

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
    public int category_id;
    private ArrayList<SingleProductDetailsModel> my_all_product_lists = new ArrayList<>();
    private ShowAllProductDataAdapter mydatas_adapters_list;
//    private int[] item_imag_lists = {R.drawable.imgf_5, R.drawable.imgf_3, R.drawable.imgf_2, R.drawable.imgf_1, R.drawable.imgf_4, R.drawable.buy, R.drawable.cart_icc, R.drawable.imgf_3, R.drawable.cart_icc, R.drawable.home_icon, R.drawable.ic_launcher_background, R.drawable.imgf_6, R.drawable.ic_launcher_background, R.drawable.imgf_7, R.drawable.imgf_8, com.denzcoskun.imageslider.R.drawable.loading, R.drawable.menu_icon, R.drawable.remove, R.drawable.user, R.drawable.search_icon, R.drawable.whatsapp};

    public ShowAllProductsFragment(int category_id) {
        // Required empty public constructor
        this.category_id = category_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viw = inflater.inflate(R.layout.fragment_show_all_products, container, false);
        txt_no_data_found = viw.findViewById(R.id.txt_no_data_exist);

        recycler_views_data_lists = (RecyclerView) viw.findViewById(R.id.recycler_view_item_lists);
        searchView = viw.findViewById(R.id.searchviews);
        searchView.setBackgroundResource(R.drawable.backgnd_while_rounded);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recycler_views_data_lists.setLayoutManager(linearLayoutManager);
//
//        if (category_id == -1) {
//
////            }
//
//        } else {
            Call<List<GetAllProductOfCategories>> call = myController.getInstance().getCategoryDetails_Api().getAllProductsOfCategory(category_id);
            call.enqueue(new Callback<List<GetAllProductOfCategories>>() {
                @Override
                public void onResponse(Call<List<GetAllProductOfCategories>> call, Response<List<GetAllProductOfCategories>> response) {
                    if (response.isSuccessful() && response != null) {
                        my_all_product_lists = new ArrayList<>();
                        List<GetAllProductOfCategories> responseItem = response.body();
                        for (int i = 0; i < responseItem.size(); i++) {
//                            if (responseItem.get(i).getImage() == null) {
//
//                                my_all_product_lists.add( MainActivity.my_all_static_product_lists.get(i%21));
//                            } else
                                my_all_product_lists.add(new SingleProductDetailsModel(responseItem.get(i).getName(), responseItem.get(i).getShortDescription() + ""));
                        }
                    } else {
                        Toast.makeText(getActivity(), " Category Details Product Product's  response is NULL " + response, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onResponse:  Category Details Product Product's  response is " + response + ".");
                        my_all_product_lists = new ArrayList<>();
                    }

//                    if (my_all_product_lists.size() == 0) {
//                        mydatas_adapters_list = new ShowAllProductDataAdapter(getContext(), MainActivity.my_all_static_product_lists, "categoryProducts_lists", getParentFragmentManager());
//                    } else
                        mydatas_adapters_list = new ShowAllProductDataAdapter(getContext(), my_all_product_lists, "categoryProducts_lists", getParentFragmentManager());
                    recycler_views_data_lists.setAdapter(mydatas_adapters_list);
//


                }

                @Override
                public void onFailure(Call<List<GetAllProductOfCategories>> call, Throwable t) {
                    Toast.makeText(getActivity(), " onFailure :" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onFailure:  " + t.getMessage());
                }
            });
//
//        }

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
        ArrayList<SingleProductDetailsModel> filteredList = new ArrayList<>();
        for (SingleProductDetailsModel singleProductDetailsModel : my_all_product_lists) {
            if (singleProductDetailsModel.getName().toLowerCase().contains(s.toLowerCase())) {
                filteredList.add(singleProductDetailsModel);
            }

        }
        if (filteredList.isEmpty()) {
            txt_no_data_found.setText(" no Data found ! ");
        } else {
            txt_no_data_found.setText("");
        }
//        mydatas_adapters_list.setFilteredListToRecyclerViews(filteredList);
    }
}