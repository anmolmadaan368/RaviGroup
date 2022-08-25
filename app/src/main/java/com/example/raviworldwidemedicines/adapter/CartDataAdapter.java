package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.ClickListener;
import com.example.raviworldwidemedicines.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CartDataAdapter extends RecyclerView.Adapter<CartDataAdapter.CartDataViewHolder> {

    ArrayList<CartMultipleDataBinder> cartlist;
    public int single_item_Layout_Id;
    private ClickListener clickListener;
    private String currentfragmentNamethatareusingthis;

    public CartDataAdapter(ArrayList<CartMultipleDataBinder> cartDataList, String currentfragmentname, int one_Item_Lays_Id, ClickListener clickListener) {
        this.cartlist = cartDataList;
        this.clickListener = clickListener;
        this.currentfragmentNamethatareusingthis = currentfragmentname;
        this.single_item_Layout_Id = one_Item_Lays_Id;
    }

    @NonNull
    @Override
    public CartDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(single_item_Layout_Id, parent, false);
        return new CartDataViewHolder(view);
    }

     public void setFilteredListToRecyclerViews(ArrayList<CartMultipleDataBinder> filtereddatalist){
        this.cartlist= filtereddatalist;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull CartDataViewHolder holder, int position) {

        CartMultipleDataBinder cartMultipleDataBinder = cartlist.get(position);
        holder.salt_compostion.setText(cartMultipleDataBinder.getSalt_name());
        holder.product_img.setImageResource(cartMultipleDataBinder.getProduct_image());
        holder.chemical_amount.setText(cartMultipleDataBinder.getChemical_amount());
        holder.manuacturer_name.setText(cartMultipleDataBinder.getManufacturer_name());
        holder.product_name.setText(cartMultipleDataBinder.getProduct_name());
    }

    @Override
    public int getItemCount() {
        return cartlist.size();
    }


    public class CartDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView product_img;
        public TextView manuacturer_name;
        public TextView chemical_amount;
        public TextView product_name;
        public TextView salt_compostion;
        private Button remove_btn;
        private Button save_btn;
        private Button buy_btn;
        public WeakReference<ClickListener> weakReference;

        public CartDataViewHolder(@NonNull View itemView) {
            super(itemView);
            product_img = (ImageView) itemView.findViewById(R.id.product_img);
            product_name = (TextView) itemView.findViewById(R.id.cart_product_title);
            manuacturer_name = (TextView) itemView.findViewById(R.id.texview_manufacturer_details);
            salt_compostion = (TextView) itemView.findViewById(R.id.txt_salt_compostion);
            chemical_amount = (TextView) itemView.findViewById(R.id.txtview_chemical_amount);
            buy_btn = (Button) itemView.findViewById(R.id.btn_buy);


            itemView.setOnClickListener(this);
            if(currentfragmentNamethatareusingthis=="ShowallProducts"){
                save_btn = (Button) itemView.findViewById(R.id.btn_saveforlater);
                save_btn.setOnClickListener(this);
            }
            else if(currentfragmentNamethatareusingthis=="WishList"){
                remove_btn = (Button) itemView.findViewById(R.id.btn_remove);
                remove_btn.setOnClickListener(this);
            }
            else if(currentfragmentNamethatareusingthis=="Cart"){
                save_btn = (Button) itemView.findViewById(R.id.btn_saveforlater);
                remove_btn = (Button) itemView.findViewById(R.id.btn_remove);
                save_btn.setOnClickListener(this);
                remove_btn.setOnClickListener(this);
            }

            weakReference = new WeakReference<>(clickListener);
            buy_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_buy) {
                Toast.makeText(view.getContext(), " " + " button is pressed . " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            } else {
                if (currentfragmentNamethatareusingthis != "ShowallProducts") {
                    if (view.getId() == R.id.btn_remove) {
                        Toast.makeText(view.getContext(), "Button Pressed is : " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();

                    }
                } else if (currentfragmentNamethatareusingthis != "WishList") {
                    if (view.getId() == R.id.btn_saveforlater) {
                        Toast.makeText(view.getContext(), "Button is Pressed  :" + String.valueOf(getAdapterPosition()) + " . ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            weakReference.get().onPositionClicked(getAdapterPosition());
        }

    }

}
