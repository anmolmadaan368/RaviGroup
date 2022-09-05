package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.fragment.BlogItemFragment;
import com.example.raviworldwidemedicines.exampl.BlogMultipleDataBinderObject;
import com.example.raviworldwidemedicines.exampl.ClickListener;
import com.example.raviworldwidemedicines.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class BlogDataAdapter extends RecyclerView.Adapter<BlogDataAdapter.BlogDataViewHolder> {

    private TextView blog_heading;
    private TextView blog_desc;
    private TextView blog_postingdate;
    public ClickListener clickListener;
    private ImageView blog_img;
    private ArrayList<BlogMultipleDataBinderObject> my_blog_lists = new ArrayList<>();
    private FragmentManager parent_fragment_manager;
    private RecyclerView recyclerView_blog_list;

    public BlogDataAdapter(ArrayList<BlogMultipleDataBinderObject> mulitpleDataBindList, FragmentManager parent_fragment_manager,ClickListener listener) {
        this.my_blog_lists = mulitpleDataBindList;
        this.parent_fragment_manager=parent_fragment_manager;
        this.clickListener=listener;
    }

    public void setFilteredDataToRecyclerViews(ArrayList<BlogMultipleDataBinderObject> my_filtered_data_Lists){
        this.my_blog_lists= my_filtered_data_Lists;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BlogDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_blog_layout, parent, false);

        return new BlogDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogDataViewHolder holder, int position) {
        BlogMultipleDataBinderObject dataViewHolder= my_blog_lists.get(position);

        holder.blog_heading.setText( dataViewHolder.getHeading_data());
        holder.blog_imag.setImageResource(dataViewHolder.getBlog_imag());
        holder.blog_posting_date.setText(dataViewHolder.getPosting_date() );
        holder.blog_desc.setText(dataViewHolder.getDesc());

    }

    @Override
    public int getItemCount() {
        return my_blog_lists.size();
    }


    public class BlogDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView blog_heading;
        private ImageView blog_imag;
        private TextView blog_posting_date;
        private LinearLayout linearLayout;
        private TextView blog_desc;
        private WeakReference<ClickListener> weakReference;


        public BlogDataViewHolder(@NonNull View itemView) {
            super(itemView);
            blog_heading = itemView.findViewById(R.id.blog_heading);
            blog_desc = itemView.findViewById(R.id.blog_desc);
            blog_posting_date = itemView.findViewById(R.id.txt_posting_date);
            linearLayout = itemView.findViewById(R.id.list_item_outer_lays);
            blog_imag = itemView.findViewById(R.id.blog_img);

            itemView.setOnClickListener(this);

            weakReference= new WeakReference<>(clickListener);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            parent_fragment_manager.beginTransaction().replace(R.id.main_lays, new BlogItemFragment()).commit();

            weakReference.get().onPositionClicked(getAdapterPosition());
        }
    }


}
