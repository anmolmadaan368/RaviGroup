package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.products.ProductResponseItem;
import com.google.gson.internal.LinkedTreeMap;

import java.util.List;

public class DataAdapterOurProduct extends ArrayAdapter<ProductResponseItem> {


    public DataAdapterOurProduct(@NonNull Context context, List<ProductResponseItem> dataModelOurProducts) {
        super(context, 0,dataModelOurProducts);
    
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)  {
        View listItemview= convertView ;
        if(listItemview==null){
            listItemview= LayoutInflater.from(getContext()).inflate(R.layout.list_item_g_view_our_products,parent,false);
        }
        ProductResponseItem ourProduct =getItem(position);
        TextView item_name=(TextView) listItemview.findViewById(R.id.idTViewI_Desc);
        ImageView item_img= (ImageView) listItemview.findViewById(R.id.gv_images);
        item_name.setText(ourProduct.getName());
         if(ourProduct.getImage() == null) {
             item_img.setImageResource(R.drawable.ic_error);
         }
         else {
             Glide.with(item_img.getContext()).load(Uri.parse((String) ((LinkedTreeMap) ourProduct.getImage().get(0)).get("src"))).error(R.drawable.ic_error).into(item_img);
         }
        return listItemview;
    }
}
