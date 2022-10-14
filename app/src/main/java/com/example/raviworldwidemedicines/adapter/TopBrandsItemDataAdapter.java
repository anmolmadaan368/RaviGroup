package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.WishListFragment;
import com.example.raviworldwidemedicines.model.TopBrandsItemDetails;

import java.util.ArrayList;

public class TopBrandsItemDataAdapter extends ArrayAdapter<TopBrandsItemDetails> {

    private Context context;
    private ArrayList<TopBrandsItemDetails> myTopBrandsLists;
    private FragmentManager  fragment_managers;
    public TopBrandsItemDataAdapter(@NonNull Context context, FragmentManager parent_fragment,  @NonNull ArrayList<TopBrandsItemDetails> objects) {
        super(context, 0,objects);
        this.context=context;
        this.myTopBrandsLists=objects;
        this.fragment_managers=parent_fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        View itemViewss= convertView;
        if (itemViewss==null){
            itemViewss= LayoutInflater.from(context).inflate(R.layout.top_brands_main_panel_items,parent,false);
        }
        TopBrandsItemDetails brandsItem=  getItem(position);
        ImageView product_images= (ImageView) itemViewss.findViewById(R.id.medicine_imgs);
        TextView original_prices= itemViewss.findViewById(R.id.txt_original_price);
        TextView discounted_price= itemViewss.findViewById(R.id.txt_selling_prices);
        TextView txt_v_btn_add= (TextView)  itemViewss.findViewById(R.id.btn_Add);
        TextView medicine_name= itemViewss.findViewById(R.id.medicine_name);

        original_prices.setText( brandsItem.getOriginal_price());
        float discounted_priceafterDiscountIsCalculated=( Float.parseFloat(brandsItem.getOriginal_price())*((100- brandsItem.getDiscount_rate())/100));
        discounted_price.setText((discounted_priceafterDiscountIsCalculated+""));
        medicine_name.setText(brandsItem.getMedicines_name());
        product_images.setImageResource(brandsItem.getMedicine_image());

    return itemViewss;
    }
}
