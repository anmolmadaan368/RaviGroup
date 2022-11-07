package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.CartFragment;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.fragment.SingleProductDetailsFragment;
import com.example.raviworldwidemedicines.model.TopBrandsItemDetails;

import java.util.ArrayList;

public class TopBrandsDataAdapter extends RecyclerView.Adapter<TopBrandsDataAdapter.topBrandsDataViewHolder> {
    ArrayList<TopBrandsItemDetails> topBrandsItemsList ;
    private FragmentManager fragmentManager;
    private String fragment_to_be_called;
    private Context context;
    @NonNull
    @Override
    public topBrandsDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item_top_brands_recycler_views_layout, parent, false);

        return new topBrandsDataViewHolder(view);
    }

    public TopBrandsDataAdapter(Context context , ArrayList<TopBrandsItemDetails> topBrandsItemsList, String fragment_to_be_called, FragmentManager fragmentManager) {
        this.topBrandsItemsList = topBrandsItemsList;
        this.fragment_to_be_called=fragment_to_be_called;
        this.fragmentManager=fragmentManager;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(topBrandsDataViewHolder holder, int position) {

        TopBrandsItemDetails brandItem= topBrandsItemsList.get(position);
        if( brandItem.getMedicine_image()!=-1 ) {
            holder.medicines_image.setImageResource(brandItem.getMedicine_image());
        }
        holder.original_price.setText(brandItem.getOriginal_price());
        if(brandItem.getDiscount_rate()!=-1){
        float discounted_prices_iss= Integer.parseInt(brandItem.getOriginal_price())* ((100-brandItem.getDiscount_rate())/100);
        holder.txt_discount_rate.setText(brandItem.getDiscount_rate()+"");
        holder.txt_discounted_price.setText(discounted_prices_iss+"");
           }
//        holder.expiary_date.setText(brandItem.getExpairy_date());
        holder.medicine_name.setText(brandItem.getMedicines_name());
        holder.manufacturer_name.setText(brandItem.getManufacturer_name());
        CartMultipleDataBinder cartMultipleDataBinder=new CartMultipleDataBinder(brandItem.getMedicine_image(),brandItem.getMedicines_name(),"dummy is your salts",brandItem.getManufacturer_name(),(243+(position*9))+"");
        holder.item_lays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(fragment_to_be_called.equals("singleProductdetails"))
                fragmentManager.beginTransaction().replace(R.id.main_lays, new SingleProductDetailsFragment( cartMultipleDataBinder, "popularMedicinesFragment")).commit();
            }
        });

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.main_lays, new CartFragment()).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return topBrandsItemsList.size();
    }

    public class topBrandsDataViewHolder extends RecyclerView.ViewHolder {

        private ImageView medicines_image;
        private TextView medicine_name;
        private TextView expiary_date;
        private TextView txt_discounted_price;
        private TextView original_price;
        private TextView manufacturer_name;
        private TextView txt_discount_rate;
        private LinearLayout item_lays;
        private TextView btn_add;

        public topBrandsDataViewHolder(@NonNull View itemView) {
            super(itemView);
            medicines_image= itemView.findViewById(R.id.med_name);
//            expiary_date= itemView.findViewById(R.id.txt_expiary_date);
            medicine_name= itemView.findViewById(R.id.txt_medicine_names);
            txt_discounted_price= itemView.findViewById(R.id.txt_discounted_price);
            txt_discount_rate= itemView.findViewById(R.id.txt_discount_rate);
            original_price= itemView.findViewById(R.id.txt_original_price);
            manufacturer_name= itemView.findViewById(R.id.txt_manufacutrer_name);
            item_lays= itemView.findViewById(R.id.txt_product_outers);
            btn_add= (TextView) itemView.findViewById(R.id.btn_Add_Item);

        }
    }
}
