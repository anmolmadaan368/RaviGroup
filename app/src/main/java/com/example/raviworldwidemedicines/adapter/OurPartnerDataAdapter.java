package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.OurPartnerDataModel;
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
        holder.partners_desc.setText( ourPartnerDataModel.getPartners_desc());
        holder.partner_name.setText(ourPartnerDataModel.getPartners_name());
        holder.partners_designation.setText(ourPartnerDataModel.getPartner_designation());

    }


    @Override
    public int getItemCount() {
        return partnersLists.size();
    }

    public class OurPartnerDataViewHolders extends RecyclerView.ViewHolder{

        ImageView partners_image;
        TextView partner_name;
        TextView partners_designation;
        TextView partners_desc;


        public OurPartnerDataViewHolders(@NonNull View itemView) {
            super(itemView);
            partners_image=  (ImageView) itemView.findViewById(R.id.our_partner_img);
            partner_name= (TextView) itemView.findViewById(R.id.our_pertners_parnter_name_txt);
            partners_desc= (TextView) itemView.findViewById(R.id.our_partners_partner_desc);
            partners_designation= (TextView)  itemView.findViewById(R.id.our_parnter_partner_designation);

        }
    }

}
