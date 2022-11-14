package com.example.raviworldwidemedicines.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.model.SingleProductDetailsModel;


public class SingleProductDetailsFragment extends Fragment {

    private CartMultipleDataBinder cartMultipleDataBinder;
    private SingleProductDetailsModel singleProductDetailsModel;
    private String layout_name_in_which_forwarded = "";

    public SingleProductDetailsFragment(CartMultipleDataBinder cartMultipleDataBinder, String lay_name_used) {
        this.cartMultipleDataBinder = cartMultipleDataBinder;
        // Required empty public constructor
        this.layout_name_in_which_forwarded = lay_name_used;
    }

    public SingleProductDetailsFragment(SingleProductDetailsModel singleProductDetailsModel) {
        this.singleProductDetailsModel = singleProductDetailsModel;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_product_details, container, false);
        TextView product_name = (TextView) view.findViewById(R.id.cart_product_title);
        ImageView product_imgs = (ImageView) view.findViewById(R.id.product_img_from_sigle_layss);
        TextView product_chemical_name = (TextView) view.findViewById(R.id.txtview_chemical_amount);
        TextView manufacturer_names = (TextView) view.findViewById(R.id.texview_manufacturer_details);
        TextView buy_btn_show_products = (TextView) view.findViewById(R.id.btn_buy_product_details);
        TextView expeiry_date = (TextView) view.findViewById(R.id.tv_expeiry_date);
        LinearLayout expiery_date_outer_lays = (LinearLayout) view.findViewById(R.id.expiery_date_outer_lays);
        TextView save_for_later_btnd = (TextView) view.findViewById(R.id.btn_saveforlater_product_details);
        TextView product_description = (TextView) view.findViewById(R.id.txt_salt_compostion);


        if (layout_name_in_which_forwarded.equals("recentlyviewedlayout")) {
            product_imgs.setImageResource(cartMultipleDataBinder.getProduct_image());
            product_name.setText(cartMultipleDataBinder.getProduct_name());
            product_chemical_name.setText(cartMultipleDataBinder.getChemical_amount());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                product_description.setText(Html.fromHtml( cartMultipleDataBinder.getShort_description(), Html.FROM_HTML_MODE_COMPACT));
            }
            else {
                product_description.setText(Html.fromHtml(cartMultipleDataBinder.getShort_description()));
            }
            expiery_date_outer_lays.setVisibility(View.GONE);
        } else {
            product_imgs.setImageResource(singleProductDetailsModel.getStatic_medicine_images());
            product_name.setText(singleProductDetailsModel.getName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                product_description.setText(Html.fromHtml( singleProductDetailsModel.getShort_description(), Html.FROM_HTML_MODE_COMPACT));
            }
            else {
                product_description.setText(Html.fromHtml(singleProductDetailsModel.getShort_description()));
            }
//            expeiry_date.setText(singleProductDetailsModel.getExpairy_date());
        }

        buy_btn_show_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new BuyFragment()).commit();
            }
        });
        save_for_later_btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new CartFragment()).commit();
            }
        });

        return view;
    }
}
