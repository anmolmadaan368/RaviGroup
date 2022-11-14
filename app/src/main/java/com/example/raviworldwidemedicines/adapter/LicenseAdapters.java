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

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public  class LicenseAdapters extends ArrayAdapter<String> {


    public LicenseAdapters(Context context, ArrayList<String> myLicenseLists) {
        super(context,0, myLicenseLists);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view= convertView;
        if(view== null) {
            view = LayoutInflater.from(this.getContext()).inflate(R.layout.list_item_licenses, parent, false);
        }
        ImageView license_imgs= view.findViewById( R.id.license_images);

        Glide.with(license_imgs.getContext()).load(Uri.parse(getItem(position))).error(R.drawable.ic_error).into(license_imgs);
        return view;
    }
}