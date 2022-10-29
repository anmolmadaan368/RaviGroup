package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class product_slider_fixed_viewAdapter extends PagerAdapter {
    Context context;
    int [] images;
    LayoutInflater layoutInflater;

    public product_slider_fixed_viewAdapter( int [] image,Context context){
        this.context=context;
        this.images=image;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public int getCount() {
        return  images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object){

        return view==((ConstraintLayout) object) ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)  {

        View itemview= layoutInflater.inflate(R.layout.product_slider_fixed_layout, container, false);
        ImageView imageView=(ImageView)     itemview.findViewById(R.id.imageview_Main);
        imageView.setImageResource(images[position]);
        Objects.requireNonNull(container).addView(itemview);
        return  itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((ConstraintLayout)  object);
    }

}
