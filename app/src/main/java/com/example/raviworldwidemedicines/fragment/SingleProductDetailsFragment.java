package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;

public class SingleProductDetailsFragment extends Fragment {

    private CartMultipleDataBinder cartMultipleDataBinder;
    public SingleProductDetailsFragment( CartMultipleDataBinder cartMultipleDataBinder){
        this.cartMultipleDataBinder=cartMultipleDataBinder;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_single_product_details, container, false);
        TextView product_name=(TextView) view.findViewById(R.id.cart_product_title);
        ImageView product_imgs= (ImageView) view.findViewById(R.id.product_img_from_sigle_layss);
        TextView product_chemical_name= (TextView) view.findViewById(R.id.txtview_chemical_amount);
        TextView manufacturer_names=(TextView) view.findViewById(R.id.texview_manufacturer_details);
        TextView buy_btn_show_products=(TextView) view.findViewById(R.id.btn_buy_product_details);

        TextView save_for_later_btnd=(TextView) view.findViewById(R.id.btn_saveforlater_product_details);

        product_imgs.setImageResource( cartMultipleDataBinder.getProduct_image());
        product_name.setText( cartMultipleDataBinder.getProduct_name());
        product_chemical_name.setText(cartMultipleDataBinder.getChemical_amount());
        buy_btn_show_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new BuyFragment()).commit();
            }
        });
        manufacturer_names.setText( cartMultipleDataBinder.getManufacturer_name());
        save_for_later_btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace( R.id.main_lays, new CartFragment()).commit();
            }
        });

        return view;
    }
}
