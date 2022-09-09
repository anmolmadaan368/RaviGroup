package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.raviworldwidemedicines.model.DataModelOurProduct;
import com.example.raviworldwidemedicines.R;

import java.util.ArrayList;

public class DataAdapterOurProduct extends ArrayAdapter<DataModelOurProduct> {


    public DataAdapterOurProduct(@NonNull Context context, ArrayList<DataModelOurProduct> dataModelOurProducts) {
        super(context, 0,dataModelOurProducts);
    
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)  {
        View listItemview= convertView ;
        if(listItemview==null){
            listItemview= LayoutInflater.from(getContext()).inflate(R.layout.list_item_g_view_our_products,parent,false);
        }
        DataModelOurProduct ourProduct =getItem(position);
        TextView item_name=(TextView) listItemview.findViewById(R.id.idTViewI_Desc);
        ImageView item_img=listItemview.findViewById(R.id.gv_images);
        item_name.setText(ourProduct.getItem_name());
        item_img.setImageResource(ourProduct.getItem_image());
        return listItemview;
    }
}
