package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpFragment extends Fragment {


    public  LoginRegisterFragment loginRegisterFragment ;
    public SignUpFragment() {
        // Required empty public constructor
    }


    private Button signup;
    private TextInputLayout name;
    private TextInputEditText mobile_no;
    private TextInputLayout u_name;
    private TextInputLayout mobile_no_outer_lays;
    private ImageView login;
    private Button btn_otp_verify;
    private LinearLayout otp_outer_lays;
    private TextInputLayout user_otp;
    private TextInputLayout confirm_password;
    private TextInputLayout u_email;
    private TextInputLayout password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =inflater.inflate(R.layout.fragment_sign_up, container, false);


        name= (TextInputLayout)view.findViewById(R.id.inpt_name) ;
        u_email=(TextInputLayout) view.findViewById(R.id.inpt_emailaddress);
        mobile_no_outer_lays=view.findViewById(R.id.contact_no_outer_lays);
        mobile_no= (TextInputEditText) view.findViewById(R.id.et_contact_no );
        confirm_password=(TextInputLayout) view.findViewById(R.id.confirm_pwd);
        user_otp=(TextInputLayout) view.findViewById(R.id.et_otp);

        btn_otp_verify=(Button) view.findViewById(R.id.btn_otp);
        otp_outer_lays= (LinearLayout) view.findViewById(R.id.otp_outer_lays);
        password =(TextInputLayout) view.findViewById(R.id.inpt_pwd);

        signup= (Button) view.findViewById(R.id.btn_signUp);
        login=(ImageView) view.findViewById(R.id.btn_Already_registered) ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRegisterFragment= new LoginRegisterFragment();
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),loginRegisterFragment);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRegisterFragment= new LoginRegisterFragment();
                Toast.makeText(getContext(), ""+" Congrats ! You are Registered Successfully . Please Login Again here  ", Toast.LENGTH_SHORT).show();
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),loginRegisterFragment);
            }
        });
        mobile_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==10){
                    confirm_password.setVisibility(View.GONE);
                    otp_outer_lays.setVisibility(View.VISIBLE);
                    mobile_no.getNextFocusForwardId();

                }
                else{
                    mobile_no.setError("Enter correct contact no");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        return view;
    }
}