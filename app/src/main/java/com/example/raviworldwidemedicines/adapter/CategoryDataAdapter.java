package com.example.raviworldwidemedicines.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.model.CategoryDetailsModel.CategoryResponseModelItem;

import java.util.List;

public class CategoryDataAdapter extends RecyclerView.Adapter<CategoryDataAdapter.viewHolder> {

    private List<CategoryResponseModelItem> allProductsFromCateory;
    CategoryDataAdapter(List<CategoryResponseModelItem> allProductsFromCategory) {
        this.allProductsFromCateory= allProductsFromCategory;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allProductsFromCateory.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
