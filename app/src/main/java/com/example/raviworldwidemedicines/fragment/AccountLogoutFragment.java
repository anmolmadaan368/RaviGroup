package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.raviworldwidemedicines.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountLogoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountLogoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CardView cardViewTerms, cardViewFAQ;




    public AccountLogoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountLogoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountLogoutFragment newInstance(String param1, String param2) {
        AccountLogoutFragment fragment = new AccountLogoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_logout, container, false);

        cardViewTerms = view.findViewById(R.id.card_view_terms);
        cardViewFAQ = view.findViewById(R.id.card_view_faq);

        cardViewTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new TermsAndConditions()).commit();
            }
        });

        cardViewFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new FaqFragment()).commit();
            }
        });

        return view;
    }
}