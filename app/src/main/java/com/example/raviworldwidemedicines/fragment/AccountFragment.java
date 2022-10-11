package com.example.raviworldwidemedicines.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.R;

import org.w3c.dom.Text;

public class AccountFragment extends Fragment {

    private TextView acc_name;
    private TextView acc_uname;
    private TextView acc_email;
    private TextView acc_mobile_no;
    private TextView editButton;
    private TextView backButton;
    private CardView cardViewProfile;
    private TextView btnLogout;
    private CardView cardViewFAQ;
    private CardView cardViewWishlist;
    private CardView cardViewTerms;
    private CardView cardViewOrder;
    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        acc_uname = (TextView) view.findViewById(R.id.tv_user_name);
        acc_email = view.findViewById(R.id.txtView_Email);
        acc_mobile_no = view.findViewById(R.id.tv_contact_no);

        cardViewProfile = view.findViewById(R.id.card_view_3);
        cardViewFAQ = view.findViewById(R.id.card_view_5);
        cardViewWishlist = view.findViewById(R.id.card_view_2);
        cardViewTerms = view.findViewById(R.id.card_view_4);
        cardViewOrder = view.findViewById(R.id.card_view_1);

//
//
//
        cardViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new EditDetailsFragment()).commit();
            }
        });


        btnLogout = (TextView) view.findViewById(R.id.logout);
//
//
//
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),new AccountLogoutFragment());
            }
        });

        cardViewFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new FaqFragment()).commit();
            }
        });

        cardViewWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new WishListFragment()).commit();
            }
        });

        cardViewTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new TermsAndConditions()).commit();
            }
        });

        cardViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new BuyFragment()).commit();
            }
        });

        return view;
    }
}