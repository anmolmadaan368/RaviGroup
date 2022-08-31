package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.CartDataAdapter;

import java.util.ArrayList;

public class CartFragment extends Fragment  {

    public RecyclerView cartList;
    public SearchView sviews;
    private CartDataAdapter cartDataAdapter;
    private Button buy_btn;
    private ArrayList<CartMultipleDataBinder> mydatalists;
    private TextView txt_no_data_found;

    public CartFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        txt_no_data_found= view.findViewById(R.id.txt_no_data_exist);
        buy_btn=(Button) view.findViewById(R.id.btn_buy);
        sviews = (SearchView) view.findViewById(R.id.searchviews);
        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);


//        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                getFragmentManager().popBackStackImmediate();
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), callback);
//

//        sviews.setQueryHint("Hints ");
//  Making whole search view Clickable here ...
        sviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sviews.setIconified(false);
            }
        });


        cartList = view.findViewById(R.id.cart_list_page);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        cartList.setLayoutManager(linearLayoutManager);
        int[] medicines_images = {R.drawable.imgf_1, R.drawable.imgf_2, R.drawable.imgf_3, R.drawable.imgf_5};
        String[] manufacturer_list = {"CELON LABORATORIES LTD", "GLENMARK PHARMACEUTICALS LTD", "MYLAN PHARMACEUTICALS PVT LTD", "CELON LABORATORIES LTD"};
        String[] salt_comp_name_list = {"ABEVMY 100MG INJECTION", "BEVACIZUMAB", "ABIRATERONE ACETATE", "ENZALUTAMIDE"};
        String[] product_name = {"ABIRAPRO 250MG TABLET", "BDENZA 40MG CAPSULE", "BDPARIB 200MG TABLET", "ABEVMY 100MG INJECTION"};
        String[] comp_amount = {"1 VIAL(s) OF 4ML", "20 TABLET(s) IN A BOTTLE", "8 CAPSULE(s) IN A STRIP", "60 TABLET(s) IN A BOTTLE"};
        mydatalists = new ArrayList<>();


        CartMultipleDataBinder cartMultipleDataBinder;
        for (int i = 0; i < manufacturer_list.length; i++) {
            cartMultipleDataBinder = new CartMultipleDataBinder(medicines_images[i], product_name[i], salt_comp_name_list[i], manufacturer_list[i], comp_amount[i]);
            mydatalists.add(cartMultipleDataBinder);
        }

        cartDataAdapter = new CartDataAdapter(mydatalists, "Cart", R.layout.cat_list_item_layout, getParentFragmentManager(), new ClickListener() {

            @Override
            public void onPositionClicked(int Position) {

            }
        });

        cartList.setAdapter(cartDataAdapter);

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
        ArrayList<CartMultipleDataBinder> filteredList= new ArrayList<>();
        for(CartMultipleDataBinder matchedElemnts :mydatalists){
            if( matchedElemnts.getManufacturer_name().toLowerCase().contains(s.toLowerCase())){
                filteredList.add( matchedElemnts);
            }
        }

        if (filteredList.isEmpty()){
            txt_no_data_found.setText(" no Data Found! ");
        }
        else {
            txt_no_data_found.setText("");
        }

        cartDataAdapter.setFilteredListToRecyclerViews(filteredList);
    }
}
