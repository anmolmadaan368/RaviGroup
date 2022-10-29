package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.ShowAllProductsFragment;
import com.example.raviworldwidemedicines.model.CategoryDetailsModel.CategoryResponseModelItem;

import java.lang.ref.WeakReference;
import java.util.List;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.DataAdapter> {

    private int list_item_view_to_be_placed;
    private ClickListener listener;
    private List<CategoryResponseModelItem> medList;
    private ShowAllProductsFragment showAllProductsFragment;

    public dataAdapter(List<CategoryResponseModelItem> medList, int list_item_view_to_be_place, ClickListener clickListener) {
        this.medList = medList;
        this.listener = clickListener;
        this.list_item_view_to_be_placed = list_item_view_to_be_place;
    }

    public void setList( List<CategoryResponseModelItem> medList) {
        this.medList = medList;
    }

    @Override
    public DataAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(list_item_view_to_be_placed, parent, false);

        return new DataAdapter(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter holder, int position) {

        CategoryResponseModelItem categoryModel= medList.get(position);
        holder.mytexts.setText(categoryModel.getName());
        if( categoryModel.getImage()!= null){
            Glide.with(holder.myimg.getContext()).load("https://raviworldwidemedicines.com/wp-content/uploads/2022/08/transplant.png").error(R.drawable.ic_left_arrow).into(holder.myimg);

        }
        else {
            holder.myimg.setImageResource(R.drawable.ic_error);
        }
    }

    @Override
    public int getItemCount() {
        return medList.size();
    }

    public class DataAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mytexts;
        private RelativeLayout category_items;
        private ImageView myimg;
        private WeakReference<ClickListener> weakReference;

        public DataAdapter(View itemView) {
            super(itemView);
            myimg = (ImageView) itemView.findViewById(R.id.myimgas);
            mytexts = (TextView) itemView.findViewById(R.id.mytxts);
            category_items = (RelativeLayout) itemView.findViewById(R.id.category_item_relative_lays);

            weakReference = new WeakReference<>(listener);

            category_items.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.category_item_relative_lays) {
                Toast.makeText(view.getContext(), " " + String.valueOf(getAdapterPosition()) + " . ", Toast.LENGTH_SHORT).show();

            }
            weakReference.get().onPositionClicked(getAdapterPosition());
        }
    }

}

