package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.ClickListener;
import com.example.raviworldwidemedicines.DynamicRvModel;
import com.example.raviworldwidemedicines.R;

import java.lang.ref.WeakReference;
import java.util.List;

public class DynamicDataAdapter extends RecyclerView.Adapter<DynamicDataAdapter.DynamicRvHolder> {

    public List<DynamicRvModel> dynamicRvModelsDataArrayLst;
    private ClickListener clickListener;
    public DynamicDataAdapter(List<DynamicRvModel> dynamicRvModels,ClickListener clickListener){
        this.dynamicRvModelsDataArrayLst=dynamicRvModels;
        this.clickListener=clickListener;
    }

    public void setFilteredListtoRecyclerViews(List<DynamicRvModel> filteredlists){
        this.dynamicRvModelsDataArrayLst=filteredlists;
        notifyDataSetChanged();

    }
    @Override
    public DynamicRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_list_item_views,parent,false);
        DynamicRvHolder dynamicRvHolder=new DynamicRvHolder(view);
        return dynamicRvHolder;
    }

    @Override
    public void onBindViewHolder(DynamicRvHolder holder, int position) {
        DynamicRvModel currentItems=  dynamicRvModelsDataArrayLst.get(position);
        holder.itemViews.setImageResource(currentItems.getImages());
        holder.itemDesc.setText(currentItems.getItemname());
    }

    @Override
    public int getItemCount() {
        return dynamicRvModelsDataArrayLst.size();
    }

    public class DynamicRvHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView itemViews;
        public TextView itemDesc;
        private WeakReference weakReference;
        private RelativeLayout relativeLayout;

        public DynamicRvHolder( View itemView) {
            super(itemView);
            weakReference= new WeakReference(clickListener);
            itemViews= (ImageView) itemView.findViewById(R.id.item_view);
            itemDesc= (TextView) itemView.findViewById(R.id.item_desc);
            relativeLayout= (RelativeLayout) itemView.findViewById(R.id.relativeItemLays);

            relativeLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            if (view.getId()==R.id.relativeItemLays){
                Toast.makeText(view.getContext(), " "+"Item pressed : "+ String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
