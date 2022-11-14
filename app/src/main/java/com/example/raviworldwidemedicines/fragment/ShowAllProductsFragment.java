package com.example.raviworldwidemedicines.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.Controller.myController;
import com.example.raviworldwidemedicines.adapter.TopBrandsDataAdapter;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.model.AllProductsByCategory.GetAllProductOfCategories;
import com.example.raviworldwidemedicines.model.AllProductsByCategory.ImageItem;
import com.example.raviworldwidemedicines.model.SingleProductDetailsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAllProductsFragment extends Fragment {

    private RecyclerView recycler_views_data_lists;
    private android.widget.SearchView getSearched_product;
    private SearchView searchView;
    private TextView txt_no_data_found;
    private int category_id;
    private ArrayList<SingleProductDetailsModel> my_all_product_lists = new ArrayList<>();
    public static ArrayList<SingleProductDetailsModel> my_all_static_product_lists = new ArrayList<>();
    private TopBrandsDataAdapter mydatas_adapters_list;
//    private int[] item_imag_lists = {R.drawable.imgf_5, R.drawable.imgf_3, R.drawable.imgf_2, R.drawable.imgf_1, R.drawable.imgf_4, R.drawable.buy, R.drawable.cart_icc, R.drawable.imgf_3, R.drawable.cart_icc, R.drawable.home_icon, R.drawable.ic_launcher_background, R.drawable.imgf_6, R.drawable.ic_launcher_background, R.drawable.imgf_7, R.drawable.imgf_8, com.denzcoskun.imageslider.R.drawable.loading, R.drawable.menu_icon, R.drawable.remove, R.drawable.user, R.drawable.search_icon, R.drawable.whatsapp};

    public ShowAllProductsFragment(int category_id) {
        // Required empty public constructor
        this.category_id = category_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viw = inflater.inflate(R.layout.fragment_show_all_products, container, false);
        txt_no_data_found = viw.findViewById(R.id.txt_no_data_exist);

        recycler_views_data_lists = (RecyclerView) viw.findViewById(R.id.recycler_view_item_lists);
        searchView = viw.findViewById(R.id.searchviews);
        searchView.setBackgroundResource(R.drawable.backgnd_while_rounded);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recycler_views_data_lists.setLayoutManager(linearLayoutManager);
        SingleProductDetailsModel singleProductDetailsModel;

        if (category_id == -1) {

            my_all_static_product_lists = new ArrayList<>();
//            for (int i = 0; i < item_imag_lists.length; i++) {
                singleProductDetailsModel = new SingleProductDetailsModel("Spasfiz 20mg\\/325mg Tablet", "\n" +
                        "COMPOSITION : Dicyclomine (20mg) + Paracetamol (325mg)\n" +
                        "\\nMANUFACTURER : Sun Pharmaceutical Industries Ltd\n" +
                        "\\nSTORAGE : Store below 30\\u00b0C<\\/p>\\n", "https://raviworldwidemedicines.com//wp-content//uploads//2022//10//download-44.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Diltiact 2% Gel", "COMPOSITION : Diltiazem (2% w/w) MANUFACTURER : Sun Pharmaceutical Industries Ltd STORAGE : Store below 30°C","https://raviworldwidemedicines.com/wp-content/uploads/2022/10/175-2.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Ointment-5g", "COMPOSITION : Fusidic Acid (2% w\\/w)\n" +
                        "\\nMANUFACTURER : Sun Pharmaceutical Industries Ltd\n" +
                        "\\nSTORAGE : Store below 30\\u00b0C<\\/p>\\n","https://raviworldwidemedicines.com//wp-content//uploads//2022//10//Ointment-5g-10002166.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("fusidic-acid-cream-500×500", "COMPOSITION : Lactitol 10gm\n" +
                        "\\nMANUFACTURER : Sun Pharmaceutical Industries Ltd","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/58c983dc-d32b-11eb-ac66-2d8af994f7f5-fusidic-acid-cream-500x500-1.png");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("alt", "COMPOSITION : Lactitol (66.67% w\\/v)\n" +
                        "\\nMANUFACTURER : Sun Pharmaceutical Industries Ltd","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/9-8-216x300-3.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("lactihep_syrup_200ml", "COMPOSITION : Luliconazole (1% w\\/v)\n" +
                        "\\nMANUFACTURER : Sun Pharmaceutical Industries Ltd","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/lactihep_syrup_200ml_0.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Antifungal Powder Spray", "Composition:\\u00a0Fluticasone (125mcg)\n" +
                        "\\nManufactured By:\\u00a0Sun Pharmaceutical Industries Ltd","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/83-1.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("", "Composition:\\u00a0Gentamicin (80mg)\n" +
                        "\\nManufactured By:\\u00a0Sun Pharmaceutical Industries Ltd","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/3-2.jpg");
                singleProductDetailsModel = new SingleProductDetailsModel("Pantoprazole Sodium", "Pantoprazole Sodium<\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/download-4-7.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Hydrochlorothiazide", " Hydrochlorothiazide (Hydrochlorothiazide)<\\/strong><\\/p>\\n\n" +
                        "\n" +
                        "Manufacturer: PD-Rx Pharmaceuticals, Inc.<\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/cp3.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Dapsone",  "Dapsone (Dapsone)\n" +
                        "\\nManufacturer: Aphena Pharma Solutions – Tennessee, LLC\n" +
                        "\\nPresentation: TABLET","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/download-2-4.png");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("MEDAPINE AC GEL", "Citalopram (Citalopram)\n" +
                        "\\nManufacturer: Aphena Pharma Solutions – Tennessee, LLC", "https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/F_0.png");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Metoprolol Succinate", "Metoprolol Succinate (Metoprolol Succinate)<\\/strong><\\/p>\\n\n" +
                        "\n" +
                        "Manufacturer: PD-Rx Pharmaceuticals, Inc.<\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/10\\/setid2d167219-e6d1-653c-e054-00144ff88e88name43063663.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Hydrogen Peroxide", "Hydrogen Peroxide – 3 Percent\\u00a0<\\/u><\\/strong><\\/p>\\n\n" +
                        "\n" +
                        "Manufacturer: Hy-Vee<\\/u><\\/p>\\n\n" +
                        "\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/download-9-2.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Penicillin V Potassium", "Penicillin V Potassium (Penicillin V Potassium)\n" +
                        "\\nManufacturer: PD-Rx Pharmaceuticals, Inc.\n" +
                        "\\nPresentation: TABLET, FILM COATED","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/TABLETS-4.jpeg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Broad Spectrum SPF 30 Up The Anti", "TITANIUM DIOXIDE, ZINC OXIDE\\u00a0<\\/u><\\/strong><\\/p>\\n\n" +
                        "\n" +
                        "Manufacturer: Biopelle, Inc.<\\/u><\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/cream-e1663826610352.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Impact Fix Prism Two Way Cake", "Octinoxate, Titanium Dioxide, Zinc Oxide – Broad Spectrum SPF 24<\\/p>\\n\n" +
                        "\n" +
                        "Manufacturer: Dong Sung Bio Pharm. Co., Ltd.<\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/2484_SugarLipTreatmentSunscreenSPF15_Coral_campaign.webp");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Metformin Hydrochloride", "Nitrofurantoin monohydrate\\/macrocrystals – (monohydrate\\/macrocrystals) (Nitrofurantoin)<\\/u><\\/strong><\\/p>\\n\n" +
                        "\n" +
                        "Manufacturer: AvKARE, Inc.<\\/u><\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/OIP-4.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Desloratadine Tablet", "Compositions : Desloratadine (5 mg\\/1)<\\/p>\\n","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/OIP.jpg");
            my_all_static_product_lists.add(singleProductDetailsModel);
                singleProductDetailsModel = new SingleProductDetailsModel("Mifebax Kit", "Composition:\\u00a0Mifepristone (200mg), Misoprostol (200mcg)","https:\\/\\/raviworldwidemedicines.com\\/wp-content\\/uploads\\/2022\\/09\\/INJECTION.png");
            my_all_static_product_lists.add(singleProductDetailsModel);
//            }

        } else {

            Call<List<GetAllProductOfCategories>> call = myController.getInstance().getCategoryDetails_Api().getAllProductsOfCategory(category_id);
            call.enqueue(new Callback<List<GetAllProductOfCategories>>() {
                @Override
                public void onResponse(Call<List<GetAllProductOfCategories>> call, Response<List<GetAllProductOfCategories>> response) {
                    if (response.isSuccessful() && response != null) {
                        my_all_product_lists = new ArrayList<>();
                        List<GetAllProductOfCategories> responseItem = response.body();
                        for (int i = 0; i < responseItem.size(); i++) {
                            if(responseItem.get(i).getImage()== null) {

                                my_all_product_lists.add(my_all_static_product_lists.get(i));
                            }
                            else
                            my_all_product_lists.add(new SingleProductDetailsModel(responseItem.get(i).getName(), responseItem.get(i).getShortDescription() + "", ((ImageItem)responseItem.get(i).getImage()).getSrc()));
                        }
                    } else {
                        Toast.makeText(getActivity(), " Category Details Product Product's  response is NULL " + response, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onResponse:  Category Details Product Product's  response is " + response + ".");
                        my_all_product_lists = new ArrayList<>();
                    }

                    if (my_all_product_lists.size() == 0) {
                        mydatas_adapters_list = new TopBrandsDataAdapter(getContext(), my_all_static_product_lists, "categoryProducts_lists", getParentFragmentManager());
                    }
                    else
                        mydatas_adapters_list= new TopBrandsDataAdapter(getContext(), my_all_product_lists, "categoryProducts_lists", getParentFragmentManager());
                    recycler_views_data_lists.setAdapter(mydatas_adapters_list);
//


                }

                @Override
                public void onFailure(Call<List<GetAllProductOfCategories>> call, Throwable t) {
                    Toast.makeText(getActivity(), " onFailure :" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onFailure:  " + t.getMessage());
                }
            });

        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });


        return viw;

    }

    private void filterList(String s) {
        ArrayList<SingleProductDetailsModel> filteredList = new ArrayList<>();
        for (SingleProductDetailsModel singleProductDetailsModel : my_all_product_lists) {
            if (singleProductDetailsModel.getName().toLowerCase().contains(s.toLowerCase()) ) {
                filteredList.add(singleProductDetailsModel);
            }

        }
        if (filteredList.isEmpty()) {
            txt_no_data_found.setText(" no Data found ! ");
        } else {
            txt_no_data_found.setText("");
        }
//        mydatas_adapters_list.setFilteredListToRecyclerViews(filteredList);
    }
}