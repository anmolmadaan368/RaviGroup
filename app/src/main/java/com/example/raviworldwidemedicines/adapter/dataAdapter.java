package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.exampl.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.ShowAllProductsFragment;
import com.example.raviworldwidemedicines.model.Model;

import java.lang.ref.WeakReference;
import java.util.List;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.DataAdapter> {

    private String[]  data;
    private int [] imgData;
    private int list_item_view_to_be_placed;
    private ClickListener listener;
    private Context context;
    List<Model> medList;
    private ShowAllProductsFragment showAllProductsFragment;
    public dataAdapter(Context context1,int [] imdata  ,String [] datas,int list_item_view_to_be_place,ClickListener clickListener){
        this.data=datas;
        this.context=context1;
        this.imgData=imdata;
        this.listener=clickListener;
        this.list_item_view_to_be_placed=list_item_view_to_be_place;
    }

    public void setList(List<Model> medList){
        this.medList = medList;
        notifyDataSetChanged();
    }

    @Override
    public DataAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(list_item_view_to_be_placed, parent,false);

        return new DataAdapter(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter holder, int position) {
        String datas= data [position];
        Log.d("Recently vie", "onBindViewHolder: "+datas);
        holder.mytexts.setText( datas);
        int myimgs= imgData[position];
        Log.d("Recently vie", "onBindViewHolder: "+myimgs);
        holder.myimg.setImageResource(myimgs);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class DataAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mytexts;
        private RelativeLayout category_items;
        private ImageView myimg;
        private WeakReference<ClickListener> weakReference;
        public DataAdapter(View itemView) {
            super(itemView);
            myimg=(ImageView) itemView.findViewById(R.id.myimgas);
            mytexts=(TextView) itemView.findViewById(R.id.mytxts);
            category_items= (RelativeLayout) itemView.findViewById(R.id.category_item_relative_lays);

            weakReference= new WeakReference<>(listener);

            category_items.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
             if(view.getId()==R.id.category_item_relative_lays){
                 Toast.makeText(view.getContext(), " "+String.valueOf( getAdapterPosition())+" . ", Toast.LENGTH_SHORT).show();

             }
             weakReference.get().onPositionClicked( getAdapterPosition());
        }
    }

}

