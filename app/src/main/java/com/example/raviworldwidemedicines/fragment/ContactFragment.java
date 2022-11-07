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
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.R;

import kotlin.Suppress;

public class ContactFragment extends Fragment {

    TextView contactform_submitBtn;

    public ContactFragment() {
        // Required empty public constructor
    }

    private TextView txt_company_Email;
    private TextView txt_company_contact_no;
    private TextView et_name;
    private TextView et_email,et_contact_no,et_subject,et_message ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        contactform_submitBtn = view.findViewById(R.id.contactform_submitBtn);
        txt_company_Email= (TextView) view.findViewById(R.id.txtView_Email);
        txt_company_contact_no= (TextView) view.findViewById(R.id.txt_Contact_No);
        et_name= (EditText) view.findViewById(R.id.contactform_name);
        et_email= (EditText) view.findViewById(R.id.contactform_email);
        et_contact_no= (EditText) view.findViewById(R.id.contactform_contactno);
        et_message= (EditText) view.findViewById(R.id.contactform_message);
        String strss_Email = "<h4><b>Email :</b> <span >ravi.raviworldwidemedicines@gmail.com</span>" +
                "</h4>";
        String stris_contactno = "<h4><b>Phone No : </b><span> +91-9994330921</span></h4>";
        if (Build.VERSION.SDK_INT >= 24) {
            txt_company_Email.setText(Html.fromHtml(strss_Email, Html.FROM_HTML_MODE_LEGACY));
            txt_company_contact_no.setText(Html.fromHtml(stris_contactno, Html.FROM_HTML_MODE_LEGACY));

        } else {
            txt_company_Email.setText(Html.fromHtml(strss_Email));
            txt_company_contact_no.setText(Html.fromHtml(stris_contactno));

        }
        txt_company_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:ravi.raviworldwidemedicines@gmail.com"));
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(emailIntent);
            }
        });
        txt_company_contact_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactIntent= new Intent(Intent.ACTION_DIAL);
                contactIntent.setData(Uri.parse("tel:+919994330921"));
                contactIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(contactIntent);
            }
        });

        contactform_submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( et_name.getText().toString().isEmpty()){
                    et_name.requestFocus();
                    et_name.setError("Only text allowed ");
                }
                else if(et_email.getText().toString().isEmpty()){
                    et_email.requestFocus();
                    et_email.setError(" Email is required. Check if valid ");
                }
                else if (et_contact_no.getText().toString().isEmpty() || et_contact_no.getText().toString().length() != 10){
                    et_contact_no.requestFocus();
                    et_contact_no.setError(" Contact no is required . Please verify it . ");
                }
                else if (et_subject.getText().toString().isEmpty() ){
                    et_subject.requestFocus();
                    et_subject.setError(" Required ! ");
                }
                else {
                    Toast.makeText(getActivity(), "You will be contacted shortly. ", Toast.LENGTH_SHORT).show();
                    getParentFragmentManager().beginTransaction().replace( R.id._mycontainer, new HomeFragment()).commit();
                }
            }
        });
        return view;
    }
}