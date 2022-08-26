package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raviworldwidemedicines.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FaqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FaqFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int bclick = 1;
    private ImageView click1,click2,click3,click4,click5,click6,click7,click8,click9,click10,click11,click12,click13,click14,click15,click16,click17,click18,click19,click20,click21,click22,click23,click24,click25,click26,click27,click28,click29;
    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20,txt21,txt22,txt23,txt24,txt25,txt26,txt27,txt28,txt29;


    public FaqFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FaqFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FaqFragment newInstance(String param1, String param2) {
        FaqFragment fragment = new FaqFragment();
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
        View view = inflater.inflate(R.layout.fragment_faq, container, false);

        click1 = view.findViewById(R.id.click1);
        click2 = view.findViewById(R.id.click2);
        click3 = view.findViewById(R.id.click3);
        click4 = view.findViewById(R.id.click4);
        click5 = view.findViewById(R.id.click5);
        click6 = view.findViewById(R.id.click6);
        click7 = view.findViewById(R.id.click7);
        click8 = view.findViewById(R.id.click8);
        click9 = view.findViewById(R.id.click9);
        click10 = view.findViewById(R.id.click10);
        click11 = view.findViewById(R.id.click11);
        click12 = view.findViewById(R.id.click12);
        click13 = view.findViewById(R.id.click13);
        click14 = view.findViewById(R.id.click14);
        click15 = view.findViewById(R.id.click15);
        click16 = view.findViewById(R.id.click16);
        click17 = view.findViewById(R.id.click17);
        click18 = view.findViewById(R.id.click18);
        click19 = view.findViewById(R.id.click19);
        click20 = view.findViewById(R.id.click20);
        click21 = view.findViewById(R.id.click21);
        click22 = view.findViewById(R.id.click22);
        click23 = view.findViewById(R.id.click23);
        click24 = view.findViewById(R.id.click24);
        click25 = view.findViewById(R.id.click25);
        click26 = view.findViewById(R.id.click26);
        click27 = view.findViewById(R.id.click27);
        click28 = view.findViewById(R.id.click28);
        click29 = view.findViewById(R.id.click29);

        txt1 = view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);
        txt3 = view.findViewById(R.id.txt3);
        txt4 = view.findViewById(R.id.txt4);
        txt5 = view.findViewById(R.id.txt5);
        txt6 = view.findViewById(R.id.txt6);
        txt7 = view.findViewById(R.id.txt7);
        txt8 = view.findViewById(R.id.txt8);
        txt9 = view.findViewById(R.id.txt9);
        txt10 = view.findViewById(R.id.txt10);
        txt11 = view.findViewById(R.id.txt11);
        txt12 = view.findViewById(R.id.txt12);
        txt13 = view.findViewById(R.id.txt13);
        txt14 = view.findViewById(R.id.txt14);
        txt15 = view.findViewById(R.id.txt15);
        txt16 = view.findViewById(R.id.txt16);
        txt17 = view.findViewById(R.id.txt17);
        txt18 = view.findViewById(R.id.txt18);
        txt19 = view.findViewById(R.id.txt19);
        txt20 = view.findViewById(R.id.txt20);
        txt21 = view.findViewById(R.id.txt21);
        txt22 = view.findViewById(R.id.txt22);
        txt23 = view.findViewById(R.id.txt23);
        txt24 = view.findViewById(R.id.txt24);
        txt25 = view.findViewById(R.id.txt25);
        txt26 = view.findViewById(R.id.txt26);
        txt27 = view.findViewById(R.id.txt27);
        txt28 = view.findViewById(R.id.txt28);
        txt29 = view.findViewById(R.id.txt29);


        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt1.setVisibility(View.VISIBLE);
                }else{
                    txt1.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt2.setVisibility(View.VISIBLE);
                }else{
                    txt2.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt3.setVisibility(View.VISIBLE);
                }else{
                    txt3.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt4.setVisibility(View.VISIBLE);
                }else{
                    txt4.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt5.setVisibility(View.VISIBLE);
                }else{
                    txt5.setVisibility(View.GONE);
                }

                bclick++;
            }
        });


        click6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt6.setVisibility(View.VISIBLE);
                }else{
                    txt6.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt7.setVisibility(View.VISIBLE);
                }else{
                    txt7.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt8.setVisibility(View.VISIBLE);
                }else{
                    txt8.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt9.setVisibility(View.VISIBLE);
                }else{
                    txt9.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt10.setVisibility(View.VISIBLE);
                }else{
                    txt10.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt11.setVisibility(View.VISIBLE);
                }else{
                    txt11.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt12.setVisibility(View.VISIBLE);
                }else{
                    txt12.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt13.setVisibility(View.VISIBLE);
                }else{
                    txt13.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt14.setVisibility(View.VISIBLE);
                }else{
                    txt14.setVisibility(View.GONE);
                }

                bclick++;
            }
        });
        click15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt15.setVisibility(View.VISIBLE);
                }else{
                    txt15.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt16.setVisibility(View.VISIBLE);
                }else{
                    txt16.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt17.setVisibility(View.VISIBLE);
                }else{
                    txt17.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt18.setVisibility(View.VISIBLE);
                }else{
                    txt18.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt19.setVisibility(View.VISIBLE);
                }else{
                    txt19.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt20.setVisibility(View.VISIBLE);
                }else{
                    txt20.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt21.setVisibility(View.VISIBLE);
                }else{
                    txt21.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt22.setVisibility(View.VISIBLE);
                }else{
                    txt22.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt23.setVisibility(View.VISIBLE);
                }else{
                    txt23.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt24.setVisibility(View.VISIBLE);
                }else{
                    txt24.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt25.setVisibility(View.VISIBLE);
                }else{
                    txt25.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt26.setVisibility(View.VISIBLE);
                }else{
                    txt26.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt27.setVisibility(View.VISIBLE);
                }else{
                    txt27.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt28.setVisibility(View.VISIBLE);
                }else{
                    txt28.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        click29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bclick % 2 !=0){
                    txt29.setVisibility(View.VISIBLE);
                }else{
                    txt29.setVisibility(View.GONE);
                }

                bclick++;
            }
        });

        return view;
    }
}