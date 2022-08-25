package com.example.raviworldwidemedicines.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.raviworldwidemedicines.R;

public class LoginRegisterFragment extends Fragment {

    private SignUpFragment signUpFragment;
    private HomeFragment homeFragment;

    public LoginRegisterFragment() {
        // Required empty public constructor
    }

    private Button btn_Go;
    private com.google.android.material.textfield.TextInputLayout login_u_name;
    private com.google.android.material.textfield.TextInputLayout login_pwd;
    private Button btn_CreateAnaccount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login_register, container, false);
        homeFragment = new HomeFragment();

        btn_Go = view.findViewById(R.id.btn_Go);
        btn_CreateAnaccount = view.findViewById(R.id.btn_createAnaccount);
        login_u_name = view.findViewById(R.id.login_uname);
        login_pwd = view.findViewById(R.id.login_pwd);

        btn_Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), " Congrats! You are Logged into your account ", Toast.LENGTH_SHORT).show();
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, homeFragment).commit();
                SharedPreferences my_login_shard_preference = view.getContext().getSharedPreferences("my_login_status", Context.MODE_PRIVATE);
                SharedPreferences.Editor modifing_Login_status = my_login_shard_preference.edit();

                modifing_Login_status.putString("uname", String.valueOf(login_u_name.getEditText()));
                modifing_Login_status.apply();
            }
         });
        btn_CreateAnaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpFragment = new SignUpFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, signUpFragment).commit();

            }
        });

        return view;
    }
}