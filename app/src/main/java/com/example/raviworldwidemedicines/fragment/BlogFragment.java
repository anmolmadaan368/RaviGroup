package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.exampl.BlogMultipleDataBinderObject;
import com.example.raviworldwidemedicines.exampl.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.BlogDataAdapter;

import java.util.ArrayList;

public class BlogFragment extends Fragment {

    private ImageView blog_imageView;
    private TextView blog_heading;
    private TextView blog_posting_date;
    private ArrayList<BlogMultipleDataBinderObject> blog_data_lists;
    private TextView blog_desc;
    private BlogDataAdapter blogDataAdapter;
    private BlogItemFragment blogItemFragment;
    private RecyclerView recyclerView_blog_data_lists;
    private TextView txt_no_data_exist;
    private int[] blog_image = {R.drawable.imgf_2, R.drawable.imgf_1, R.drawable.imgf_3, R.drawable.imgf_4, R.drawable.imgf_5};
    private SearchView blog_searchview_layss;

    public BlogFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blog, container, false);
        blog_heading= (TextView) view.findViewById(R.id.blog_heading);
        blog_posting_date= (TextView) view.findViewById(R.id.txt_posting_date);
        blog_desc= (TextView) view.findViewById(R.id.blog_desc);
        recyclerView_blog_data_lists = view.findViewById(R.id.recycler_view_blog_list);
        txt_no_data_exist= view.findViewById(R.id.no_data_exist_txt);
        blog_searchview_layss= view.findViewById(R.id.blog_item_searchviews);
        blogItemFragment=new BlogItemFragment();

        blog_imageView= (ImageView) view.findViewById(R.id.blog_img);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView_blog_data_lists.setLayoutManager(linearLayoutManager);

        blog_data_lists =new ArrayList<>();
        BlogMultipleDataBinderObject multipledataBinder;
        for (int i=0; i<blog_image.length; i++){
            multipledataBinder =new BlogMultipleDataBinderObject("Heading Data is Here:  "+(i+2), blog_image[i],"posting date is "+(i+4)+" ,aug,2022 . ","Blog No: "+(i+6)+" . This k ksj;lj la kk fdsldsj kl;d sl jksdl;  ds;l jd skl; dsj k;l sfdkjkdsjkdsj kldssj dsdkljds l dsjkds l; slk; ds j sj lk l  . .   .   ");
            blog_data_lists.add(multipledataBinder);
        }
        blogDataAdapter = new BlogDataAdapter(blog_data_lists, getParentFragmentManager(), new ClickListener() {
            @Override
            public void onPositionClicked(int Position)  {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, blogItemFragment).commit();

            }
        });
        recyclerView_blog_data_lists.setAdapter(blogDataAdapter);



        blog_searchview_layss.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);

                return false;
            }
        });






        return view;
    }

    private void filterList(String s) {
        ArrayList<BlogMultipleDataBinderObject> filteredLists= new ArrayList<>();
        for ( BlogMultipleDataBinderObject blog_item_lists : blog_data_lists){
            if(blog_item_lists.getHeading_data().toLowerCase().contains(s.toLowerCase())){
                filteredLists.add(blog_item_lists);
            }
        }
        if(filteredLists.isEmpty()){
            txt_no_data_exist.setText(" no data founded! ");
        }
        else{
            txt_no_data_exist.setText("");
        }
        blogDataAdapter.setFilteredDataToRecyclerViews(filteredLists);

    }
}