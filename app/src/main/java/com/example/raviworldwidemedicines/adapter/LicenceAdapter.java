package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.ModelLicence;

import java.util.ArrayList;

public class LicenceAdapter extends RecyclerView.Adapter<LicenceAdapter.myviewholder> {

    ArrayList<ModelLicence>licecedata;

    public LicenceAdapter(ArrayList<ModelLicence> licecedata) {
        this.licecedata = licecedata;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.licence_desgine_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.image_licence_demo.setImageResource(licecedata.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return licecedata.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{


        ImageView image_licence_demo;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            image_licence_demo = itemView.findViewById(R.id.image_licence_demo);
        }
    }
}
