package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.model.OurPartnerDataModel;
import com.example.raviworldwidemedicines.R;

import java.util.ArrayList;

public class OurPartnerDataAdapter extends RecyclerView.Adapter<OurPartnerDataAdapter.OurPartnerDataViewHolders> {

    ArrayList<OurPartnerDataModel> partnersLists= new ArrayList<>();
    public OurPartnerDataAdapter(ArrayList<OurPartnerDataModel> mylists){
        this.partnersLists =mylists;
    }

    @NonNull
    @Override
    public OurPartnerDataViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.our_partners_list_item_layout, parent,false);

        return new OurPartnerDataViewHolders(view);
    }

    @Override
    public void onBindViewHolder(OurPartnerDataViewHolders holder, int position) {
        OurPartnerDataModel ourPartnerDataModel= partnersLists.get(position);
        holder.partners_image.setImageResource(ourPartnerDataModel.getPartners_image());

    }


    @Override
    public int getItemCount() {
        return partnersLists.size();
    }

    public class OurPartnerDataViewHolders extends RecyclerView.ViewHolder{

        ImageView partners_image;


        public OurPartnerDataViewHolders(@NonNull View itemView) {
            super(itemView);
            partners_image=  (ImageView) itemView.findViewById(R.id.our_partner_img);

        }
    }

}
