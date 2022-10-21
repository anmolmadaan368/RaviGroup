package com.example.raviworldwidemedicines.fragment;

import android.content.Intent;
import android.net.Uri;
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

    private TextView txt_Email_add;
    private TextView txt_Contact_no;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        txt_Email_add = (TextView) view.findViewById(R.id.txt_Email_add);
        txt_Contact_no = (TextView) view.findViewById(R.id.txt_Contact_no);
        contactform_submitBtn = view.findViewById(R.id.contactform_submitBtn);

        String strss_Email = "<h4><b>Email :</b> <span >ravi.raviworldwidemedicines@gmail.com</span>" +
                "</h4>";
        String stris_contactno = "<h4><b>Phone No : </b><span> +91-9994330921</span></h4>";
        if (Build.VERSION.SDK_INT >= 24) {
            txt_Email_add.setText(Html.fromHtml(strss_Email, Html.FROM_HTML_MODE_LEGACY));
            txt_Contact_no.setText(Html.fromHtml(stris_contactno, Html.FROM_HTML_MODE_LEGACY));

        } else {
            txt_Email_add.setText(Html.fromHtml(strss_Email));
            txt_Contact_no.setText(Html.fromHtml(stris_contactno));

        }
        txt_Email_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:ravi.raviworldwidemedicines@gmail.com"));
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(emailIntent);
            }
        });
        txt_Contact_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactIntent= new Intent(Intent.ACTION_DIAL);
                contactIntent.setData(Uri.parse("tel:+919994330921"));
                contactIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(contactIntent);
            }
        });


        return view;
    }
}