package com.example.raviworldwidemedicines.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.R;

import org.w3c.dom.Text;

public class AccountFragment extends Fragment {

    private TextView acc_name;
    private TextView acc_uname;
    private TextView acc_email;
    private TextView acc_mobile_no;
    private ImageView user_image;
    private Button editButton;
    private Button backButton;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        acc_uname = (TextView) view.findViewById(R.id.login_uname);
        acc_email = view.findViewById(R.id.account_email_txt);
        acc_mobile_no = view.findViewById(R.id.account_mobile_txt);
        user_image = view.findViewById(R.id.account_user_pic);
        editButton = view.findViewById(R.id.Edit_Button);



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new EditDetailsFragment()).commit();
            }
        });



//        .;

        return view;

    }
}