package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpFragment extends Fragment {


    public  LoginRegisterFragment loginRegisterFragment ;
    public SignUpFragment() {
        // Required empty public constructor
    }


    private Button signup;
    private TextInputLayout name;
    private TextInputLayout mobile_no;
    private TextInputLayout u_name;
    private ImageView login;
    private TextInputLayout u_email;
    private TextInputLayout password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =inflater.inflate(R.layout.fragment_sign_up, container, false);


        name= (TextInputLayout)view.findViewById(R.id.inpt_name) ;
        u_name= (TextInputLayout) view.findViewById(R.id.login_uname);
        u_email=(TextInputLayout) view.findViewById(R.id.inpt_emailaddress);
        mobile_no= (TextInputLayout) view.findViewById(R.id.et_contact_no );
        password =(TextInputLayout) view.findViewById(R.id.inpt_pwd);

        signup= (Button) view.findViewById(R.id.btn_signUp);
        login=(ImageView) view.findViewById(R.id.btn_Already_registered) ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRegisterFragment= new LoginRegisterFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, loginRegisterFragment).commit();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRegisterFragment= new LoginRegisterFragment();
                Toast.makeText(getContext(), ""+" Congrats ! You are Registered Successfully . Please Login Again here  ", Toast.LENGTH_SHORT).show();
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, loginRegisterFragment).commit();
            }
        });

        return view;
    }
}