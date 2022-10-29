package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.net.Uri;
import android.telephony.ims.ImsReasonInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.raviworldwidemedicines.model.DataModelOurProduct;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.products.ProductsModel;
import com.example.raviworldwidemedicines.model.products.ProductsModelItem;

import java.util.ArrayList;
import java.util.List;

public class DataAdapterOurProduct extends ArrayAdapter<ProductsModelItem> {


    public DataAdapterOurProduct(@NonNull Context context, List<ProductsModelItem> dataModelOurProducts) {
        super(context, 0,dataModelOurProducts);
    
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)  {
        View listItemview= convertView ;
        if(listItemview==null){
            listItemview= LayoutInflater.from(getContext()).inflate(R.layout.list_item_g_view_our_products,parent,false);
        }
        ProductsModelItem ourProduct =getItem(position);
        TextView item_name=(TextView) listItemview.findViewById(R.id.idTViewI_Desc);
        ImageView item_img= (ImageView) listItemview.findViewById(R.id.gv_images);
        item_name.setText(ourProduct.getName());

        Glide.with(item_img.getContext()).load(Uri.parse(ourProduct.getImage().getSrc())).error(R.drawable.ic_error).into(item_img);
        return listItemview;
    }
}
