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
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.ShowAllProductsFragment;

import java.lang.ref.WeakReference;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.DataAdapter> {

    private String[]  data;
    private Integer [] imgData;
    private int list_item_view_to_be_placed;
    private ClickListener listener;
    private ShowAllProductsFragment showAllProductsFragment;
    public dataAdapter(Integer [] imdata  ,String [] datas,int list_item_view_to_be_place,ClickListener clickListener){
        this.data=datas;
        this.imgData=imdata;
        this.listener=clickListener;
        this.list_item_view_to_be_placed=list_item_view_to_be_place;
    }

    @Override
    public DataAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(list_item_view_to_be_placed, parent,false);
        return new DataAdapter(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter holder, int position) {
        String datas= data [position];
        holder.mytexts.setText( datas);
        int myimgs= imgData[position];
        holder.myimg.setImageResource(myimgs);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class DataAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mytexts;
        private RelativeLayout category_item;
        private ImageView myimg;
        private WeakReference<ClickListener> weakReference;
        public DataAdapter(View itemView) {
            super(itemView);
            myimg=(ImageView) itemView.findViewById(R.id.myimg);
            mytexts=(TextView) itemView.findViewById(R.id.mytxts);
            category_item=(RelativeLayout) itemView.findViewById(R.id.category_item_relative_layss);

            weakReference= new WeakReference<>(listener);

            category_item.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
             if(view.getId()==R.id.category_item_relative_layss){
                 Toast.makeText(view.getContext(), " "+String.valueOf( getAdapterPosition())+" . ", Toast.LENGTH_SHORT).show();

             }
             weakReference.get().onPositionClicked( getAdapterPosition());
        }
    }

}

