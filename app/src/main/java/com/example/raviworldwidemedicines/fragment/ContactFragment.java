package com.example.raviworldwidemedicines.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.R;

import kotlin.Suppress;

public class ContactFragment extends Fragment {

    TextView contactform_submitBtn;
    public ContactFragment() {
        // Required empty public constructor
    }

    public TextView txtViewContsctdeatil;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        txtViewContsctdeatil = (TextView) view.findViewById(R.id.txtViewContactdetail);
        contactform_submitBtn= view.findViewById(R.id.contactform_submitBtn);

        String strss = "<h6><b>Email :</b> <spnan style=\"font-size:15px;\">ravi.raviworldwidemedicines@gmail.com</spnan>\n" +
                "</h6><h6><b>Phone No : </b><spnan style=\"font-size:15px;\"> +91-9994330921</spnan>\n" +
                "</h6>";

        if (Build.VERSION.SDK_INT >= 24) {
            txtViewContsctdeatil.setText(Html.fromHtml(strss, Html.FROM_HTML_MODE_LEGACY));

        } else {
            txtViewContsctdeatil.setText(Html.fromHtml(strss));


            return view;
        }




        return view;
    }
}