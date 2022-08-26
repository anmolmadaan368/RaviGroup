package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.CartFragment;
import com.example.raviworldwidemedicines.fragment.HomeFragment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class RecentlyViewAdapter extends RecyclerView.Adapter<RecentlyViewAdapter.Recently_View_Data_View_Holder> {

    private ArrayList<CartMultipleDataBinder> myRecently_viewed_lists = new ArrayList<>();
    public ClickListener listener;
    private FragmentManager parents_Fragments;
    public RecentlyViewAdapter(ArrayList<CartMultipleDataBinder> my_recent_lists, FragmentManager parent_Fragments,ClickListener clickListener) {
        this.myRecently_viewed_lists = my_recent_lists;
        this.listener=clickListener;
        this.parents_Fragments=parent_Fragments;
    }

    @NonNull
    @Override
    public Recently_View_Data_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_productsdetails_layouts, parent, false);

        return new Recently_View_Data_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recently_View_Data_View_Holder holder, int position) {

        CartMultipleDataBinder cartMultipleDataBinder = myRecently_viewed_lists.get(position);
        holder.product_img.setImageResource(cartMultipleDataBinder.getProduct_image());
        holder.chemical_name.setText(cartMultipleDataBinder.getChemical_amount());
        holder.salt_comp.setText(cartMultipleDataBinder.getSalt_name());
        holder.manufacturer_name.setText(cartMultipleDataBinder.getManufacturer_name());


    }

    @Override
    public int getItemCount() {
        return myRecently_viewed_lists.size();
    }

    public class Recently_View_Data_View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView product_img;
        private TextView product_title_txt;
        private TextView salt_comp;
        private TextView manufacturer_name;
        private TextView chemical_name;
        private Button save_later_btn;
        private Button buy_btn;
        private WeakReference<ClickListener> weakReference;

        public Recently_View_Data_View_Holder(@NonNull View itemView) {
            super(itemView);

            product_img = (ImageView) itemView.findViewById(R.id.product_img);
            product_title_txt = (TextView) itemView.findViewById(R.id.cart_product_title);
            salt_comp = (TextView) itemView.findViewById(R.id.txt_salt_compostion);
            manufacturer_name = (TextView) itemView.findViewById(R.id.txt_salt_compostion);
            chemical_name = (TextView) itemView.findViewById(R.id.txtview_chemical_amount);
            save_later_btn = (Button) itemView.findViewById(R.id.btn_saveforlater);
            buy_btn = (Button) itemView.findViewById(R.id.btn_buy);
            weakReference=new WeakReference<>(listener);

            buy_btn.setOnClickListener(this);
            save_later_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_buy) {
                Toast.makeText(buy_btn.getContext(), " Buy Button is clicked", Toast.LENGTH_SHORT).show();
                parents_Fragments.beginTransaction().replace(R.id.main_lays, new HomeFragment()).commit();
            } else if (view.getId() == R.id.btn_saveforlater) {
                Toast.makeText(save_later_btn.getContext(), " Save for Later is clicked ", Toast.LENGTH_SHORT).show();
                parents_Fragments.beginTransaction().replace(R.id.main_lays, new CartFragment()).commit();
            }
            weakReference.get().onPositionClicked(getAdapterPosition());
        }
    }
}
