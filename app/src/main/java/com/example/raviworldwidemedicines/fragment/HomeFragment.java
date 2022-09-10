package com.example.raviworldwidemedicines.fragment;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.adapter.AvailableBrandsDataAdapter;
import com.example.raviworldwidemedicines.adapter.TopBrandsItemDataAdapter;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.dataAdapter;
import com.example.raviworldwidemedicines.adapter.product_slider_fixed_viewAdapter;
import com.example.raviworldwidemedicines.model.AvailableBrandsDataModel;
import com.example.raviworldwidemedicines.model.TopBrandsItemDetails;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    public ViewPager pager;
    private GridView grid_view_top_brands;
    public SearchView sviews;
    private RecyclerView recyclerView_recently_viewed;
    private Button btn_recently_viewed;
    private TextView btn_availble_brands_view_alls;
    private GridView grid_view_available_brands;
    private ArrayList<AvailableBrandsDataModel> myAvailable_brands_list = new ArrayList<>();
    private TextView txt_btn_view;
    private ShowAllProductsFragment showAllProductsFragment;

    public com.example.raviworldwidemedicines.adapter.product_slider_fixed_viewAdapter product_slider_fixed_viewAdapter;
    private int[] product_slider_fixed_images = {R.drawable.medicine_image_7, R.drawable.medicine_image_2, R.drawable.medicine_image_3, R.drawable.medicine_image_5, R.drawable.medicine_image_6};


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_views);
        ImageSlider imageSlider = view.findViewById(R.id.img_slider);
        pager = (ViewPager) view.findViewById(R.id.viewPagerIds);
        btn_recently_viewed = (Button) view.findViewById(R.id.btn_recently_viewed);
        grid_view_top_brands = view.findViewById(R.id.grid_view_top_brands);
        sviews = (SearchView) view.findViewById(R.id.searchviews);
        txt_btn_view = view.findViewById(R.id.btns_popular_medicines_views);
        grid_view_available_brands = (GridView) view.findViewById(R.id.grid_view_avaialble_brands);
        btn_availble_brands_view_alls = view.findViewById(R.id.txt_available_brands_view_btn_views);
        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);

//        sviews.setQueryHint("Hints ");
//  Making whole search view Clickable here ...
        sviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sviews.setIconified(false);
            }
        });


//       Fixed Image Slider Code


        product_slider_fixed_viewAdapter = new product_slider_fixed_viewAdapter(product_slider_fixed_images, getActivity().getApplicationContext());
        pager.setAdapter(product_slider_fixed_viewAdapter);

//      Auto Image Slider Code


        ArrayList<SlideModel> slidemodels = new ArrayList<>();
        slidemodels.add(new SlideModel((R.drawable.medicine_image_8), ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.medicine_image_9, ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.medicine_image_15, ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.medicine_image_11, ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.medicine_image_12, ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.medicine_image_14, ScaleTypes.FIT));
        imageSlider.setImageList(slidemodels, ScaleTypes.FIT);


//       RecyclerView Code

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        int[] myimgs = {R.drawable.cardiology_cat, R.drawable.cat_transplant, R.drawable.antibactrial_cat, R.drawable.dermatology_cat, R.drawable.endocrinology_cat, R.drawable.blood_pressure_cat};
        String[] list_names = {"Cardiology", "Transplant", "Antibactrial", "Dermatology", "Endocrinology", "Blood Pressure"};
        dataAdapter adapter = new dataAdapter(this.getContext(), myimgs, list_names, R.layout.list_item_view, new ClickListener() {
            @Override
            public void onPositionClicked(int Position) {
                showAllProductsFragment = new ShowAllProductsFragment();
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),showAllProductsFragment);
            }
        });

        recyclerView.setAdapter(adapter);
//

//      Recently viewwd Panel code is here
        btn_recently_viewed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),new RecentlyViewedFragment(new ArrayList<>()));
            }
        });


        recyclerView_recently_viewed = view.findViewById(R.id.recently_viewed_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView_recently_viewed.setLayoutManager(layoutManager);
        int[] myimgs2 = {R.drawable.medicine_image_3, R.drawable.medicine_image_2, R.drawable.medicine_image_4, R.drawable.medicine_image_5, R.drawable.medicine_image_6};
        CartMultipleDataBinder item_singleDatas = new CartMultipleDataBinder(myimgs2[1], "sj", "sij", "sjs", "sjd");
        String[] list_name3s = {"0 min ago", "2 min ago", "3 min ago", "4 min ago", "1 hr ago "};
        dataAdapter adapter1 = new dataAdapter(this.getContext(), myimgs2, list_name3s, R.layout.recently_viewed_list_item_views, new ClickListener() {
            @Override
            public void onPositionClicked(int Position) {
                showAllProductsFragment = new ShowAllProductsFragment();
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),new SingleProductDetailsFragment(item_singleDatas));
            }
        });

        recyclerView_recently_viewed.setAdapter(adapter1);

        ArrayList<TopBrandsItemDetails> topBrandsItemDetailslists = new ArrayList<>();
        topBrandsItemDetailslists.add(new TopBrandsItemDetails("Abacavir / lamivudine (Epzicom®)", "02 feb,2024", "1000", "SII", R.drawable.medicine_image_3, 24));
        topBrandsItemDetailslists.add(new TopBrandsItemDetails("Acyclovir", "04 mar,2025", "2000", "Cipla", R.drawable.medicine_image_4, 24));
        topBrandsItemDetailslists.add(new TopBrandsItemDetails("Abacavir", "07 may,2024", "1187", "Dolo", R.drawable.medicine_image_5, 23));
        topBrandsItemDetailslists.add(new TopBrandsItemDetails("Alendronate", "06 sep,2026", "2227", "Dettol", R.drawable.medicine_image_2, 7));

        TopBrandsItemDataAdapter mainPanelTopBrandsItemsAdapters = new TopBrandsItemDataAdapter(this.getContext(), topBrandsItemDetailslists);
        grid_view_top_brands.setAdapter(mainPanelTopBrandsItemsAdapters);

        txt_btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),new TopBrandsListFragment());
            }
        });


        String[] available_brands = {"Cipla", "DayHawk", "SII", "Dettol", "Medihuman", "Mankind"};
        for (int i = 0; i < 6; i++) {
            AvailableBrandsDataModel brandsDataModel = new AvailableBrandsDataModel(R.drawable.medicine_image_3);
            myAvailable_brands_list.add(brandsDataModel);
        }
        AvailableBrandsDataAdapter availableBrandsDataAdapter = new AvailableBrandsDataAdapter(this.getActivity().getApplicationContext(), myAvailable_brands_list);

        grid_view_available_brands.setAdapter(availableBrandsDataAdapter);
        btn_availble_brands_view_alls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(),new AvailableBrandsFragment());
            }
        });
        return view;

    }
}