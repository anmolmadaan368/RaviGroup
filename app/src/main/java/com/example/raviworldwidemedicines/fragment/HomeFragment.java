package com.example.raviworldwidemedicines.fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.raviworldwidemedicines.Controller.myController;
import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.adapter.AvailableBrandsDataAdapter;
import com.example.raviworldwidemedicines.adapter.TopBrandsItemDataAdapter;
import com.example.raviworldwidemedicines.databinding.FragmentHomeBinding;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.dataAdapterCategory;
import com.example.raviworldwidemedicines.adapter.product_slider_fixed_viewAdapter;
import com.example.raviworldwidemedicines.model.AvailableBrandsDataModel;
import com.example.raviworldwidemedicines.model.CategoryDetailsModel.CategoryResponseModelItem;
import com.example.raviworldwidemedicines.model.SingleProductDetailsModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    private FragmentHomeBinding homeBinding;
    public ViewPager pager;
    private GridView grid_view_top_brands;
    public SearchView sviews;
    private RecyclerView recyclerView_recently_viewed;
    private Button btn_recently_viewed;
    private TextView btn_availble_brands_view_alls;
    private GridView grid_view_available_brands;
    private ArrayList<AvailableBrandsDataModel> myAvailable_brands_list = new ArrayList<>();
    private MaterialButton btn_refer;
    private TextView txt_btn_view;
    private CardView rate_Us_Lays;
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
        homeBinding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = homeBinding.getRoot();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_views);
        ImageSlider imageSlider = view.findViewById(R.id.img_slider);
        pager = (ViewPager) view.findViewById(R.id.viewPagerIds);
        btn_recently_viewed = (Button) view.findViewById(R.id.btn_recently_viewed);
        grid_view_top_brands = view.findViewById(R.id.grid_view_top_brands);
        sviews = (SearchView) view.findViewById(R.id.searchviews);
        txt_btn_view = (TextView) view.findViewById(R.id.btns_popular_medicines_views);
        grid_view_available_brands = (GridView) view.findViewById(R.id.grid_view_avaialble_brands);
        rate_Us_Lays= (CardView) view.findViewById(R.id.card_view_2);
        btn_refer = (MaterialButton) view.findViewById(R.id.btn_refer);
        btn_availble_brands_view_alls = view.findViewById(R.id.txt_available_brands_view_btn_views);
        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);

//        sviews.setQueryHint("Hints ");
//  Making whole search view Clickable here ...
        sviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                sviews.setIconified(false);
            }
        });


//       Fixed Image Slider Code


        product_slider_fixed_viewAdapter = new product_slider_fixed_viewAdapter(product_slider_fixed_images, getActivity().getApplicationContext());
        pager.setAdapter(product_slider_fixed_viewAdapter);

//      Auto Image Slider Code


        ArrayList<SlideModel> slidemodels = new ArrayList<>();
        slidemodels.add(new SlideModel((R.drawable.slider3), ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.slider1, ScaleTypes.FIT));
        slidemodels.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        imageSlider.setImageList(slidemodels, ScaleTypes.FIT);


//       RecyclerView Code

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        Call<List<CategoryResponseModelItem>> call= myController.getInstance().getCategoryDetails_Api().getData();
        call.enqueue(new Callback<List<CategoryResponseModelItem>>() {
            @Override
            public void onResponse(Call<List<CategoryResponseModelItem>> call, Response<List<CategoryResponseModelItem>> response) {
                if (response.isSuccessful() && response != null) {
                     List<CategoryResponseModelItem> myResponseLists= response.body();

                    dataAdapterCategory adapter = new dataAdapterCategory(myResponseLists , R.layout.list_item_view, new ClickListener() {
                        @Override
                        public void onPositionClicked(int Position) {
                            showAllProductsFragment = new ShowAllProductsFragment(myResponseLists.get(Position).getId());
                            MainActivity.replaceCurrentFragment(getParentFragmentManager(), showAllProductsFragment);
                        }
                    });

                    recyclerView.setAdapter(adapter);
//
                }
                else {
                    Toast.makeText(getActivity(), " Response is null  ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CategoryResponseModelItem>> call, Throwable t) {
                Toast.makeText(getActivity(), " Not getting response. "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFaiure: "+ t.getMessage());
            }
        });


//      Recently viewwd Panel code is here
        btn_recently_viewed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new RecentlyViewedFragment(new ArrayList<>()));
            }
        });


        recyclerView_recently_viewed = view.findViewById(R.id.recently_viewed_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView_recently_viewed.setLayoutManager(layoutManager);
        int[] myimgs2 = {R.drawable.medicine_image_3, R.drawable.medicine_image_2, R.drawable.medicine_image_4, R.drawable.medicine_image_5, R.drawable.medicine_image_6};
        CartMultipleDataBinder item_singleDatas = new CartMultipleDataBinder(myimgs2[1], "sj", "sij", "sjs", "sjd");
        String[] list_name3s = {"0 min ago", "2 min ago", "3 min ago", "4 min ago", "1 hr ago "};
//        dataAdapterCategory adapter1 = new dataAdapterCategory(this.getContext(), myimgs2, list_name3s, R.layout.recently_viewed_list_item_views, new ClickListener() {
//            @Override
//            public void onPositionClicked(int Position) {
//                showAllProductsFragment = new ShowAllProductsFragment();
//                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new SingleProductDetailsFragment(item_singleDatas, "recentlyviewedlayout"));
//            }
//        });


        //   Rate us  Layout


        rate_Us_Lays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new RateusFragment());
            }
        });



//        recyclerView_recently_viewed.setAdapter(adapter1);

        ArrayList<SingleProductDetailsModel> singleProductDetailslistModels = new ArrayList<>();
        singleProductDetailslistModels.add(new SingleProductDetailsModel("Abacavir / lamivudine (Epzicom®)", "SII", R.drawable.medicine_image_3));
        singleProductDetailslistModels.add(new SingleProductDetailsModel("Acyclovir", "Cipla", R.drawable.medicine_image_4));
        singleProductDetailslistModels.add(new SingleProductDetailsModel("Abacavir", "Dolo", R.drawable.medicine_image_5));
        singleProductDetailslistModels.add(new SingleProductDetailsModel("Alendronate", "Dettol", R.drawable.medicine_image_2));

        TopBrandsItemDataAdapter mainPanelTopBrandsItemsAdapters = new TopBrandsItemDataAdapter(this.getContext(), getParentFragmentManager(), singleProductDetailslistModels);

        grid_view_top_brands.setAdapter(mainPanelTopBrandsItemsAdapters);

        grid_view_top_brands.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView btn_add_popular_medicines = (TextView) view.findViewById(R.id.btn_Add);
                btn_add_popular_medicines.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity.replaceCurrentFragment(getParentFragmentManager(), new CartFragment());
                    }
                });

            }
        });

        txt_btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new TopBrandsFragment());
            }
        });


        //  Refer and earn here ....

        btn_refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), " Referred to another person. ", Toast.LENGTH_SHORT).show();
            }
        });
        

        // Call to action button

        homeBinding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent = new Intent(Intent.ACTION_DIAL);
                call_intent.setData(Uri.parse("tel:+919994330921"));
                call_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(call_intent);
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
                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new AvailableBrandsFragment());
            }
        });
        return view;

}
}