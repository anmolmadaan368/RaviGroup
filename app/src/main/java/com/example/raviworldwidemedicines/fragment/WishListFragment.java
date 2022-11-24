package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.CartDataAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class WishListFragment extends Fragment {

    public SearchView  sviews;
    private TextView txts_no_data_founded;
    private Button btn_wish_login;
    private ArrayList<CartMultipleDataBinder> mydataLists;
    private CartDataAdapter dataAdapter;
    public WishListFragment() {
        // Required empty public constructor
    }

    public RecyclerView recyclerView_wishList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wish_list, container, false);
        recyclerView_wishList = view.findViewById(R.id.recycler_views_wishlist);
        txts_no_data_founded= view.findViewById(R.id.txt_no_data_exists);
        sviews = (SearchView) view.findViewById(R.id.searchviews);
        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);

        btn_wish_login= (MaterialButton) view.findViewById(R.id.btn_login_wishlist);


        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView_wishList.setLayoutManager(layoutManager);

        int []  item_lists={R.drawable.imgf_5,R.drawable.imgf_3,R.drawable.imgf_2,R.drawable.imgf_1,R.drawable.imgf_4,R.drawable.buy,R.drawable.cart_icc,R.drawable.imgf_3,R.drawable.cart_icc,R.drawable.home_icon,R.drawable.ic_launcher_background,R.drawable.imgf_6,R.drawable.ic_launcher_background,R.drawable.imgf_7,R.drawable.imgf_8,R.drawable.loading,R.drawable.menu_icon,R.drawable.remove,R.drawable.user,R.drawable.search_icon,R.drawable.whatsapp };
         mydataLists= new ArrayList<>();
        for (int i = 1; i <item_lists.length; i++) {
             mydataLists.add(new CartMultipleDataBinder(item_lists[i],"product ; "+i ,"Salt No. :"+i,"Manufacturer :"+i,"Chemical Amount is : "+(i+1)));
        }

        dataAdapter=new CartDataAdapter(mydataLists, "WishList", R.layout.list_item_layout_wishlist, getParentFragmentManager(), new ClickListener() {
            @Override
            public void onPositionClicked(int Position) {

            }
        });

        recyclerView_wishList.setAdapter(dataAdapter);

        ;

        btn_wish_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new LoginRegisterFragment());
            }
        });

        sviews.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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









        return view;

    }

    private void filterList(String s) {
        ArrayList<CartMultipleDataBinder>  filteredList= new ArrayList<>();
        for(CartMultipleDataBinder matcheditems: mydataLists){
            if ( matcheditems.getProduct_name().toLowerCase().contains(s.toLowerCase())){
                filteredList.add(matcheditems);
            }
        }

        if(filteredList.isEmpty()){
            txts_no_data_founded.setText("no data found ! ");
        }
        else {
            txts_no_data_founded.setText("");
        }
        dataAdapter.setFilteredListToRecyclerViews(filteredList);

    }
}