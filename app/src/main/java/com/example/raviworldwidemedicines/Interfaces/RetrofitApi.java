package com.example.raviworldwidemedicines.Interfaces;

import com.example.raviworldwidemedicines.model.CategoryDetailsModel.CategoryResponseModelItem;
import com.example.raviworldwidemedicines.model.products.ProductsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("custom_api/get_all_category.php")

        //on below line we are creating a method to post our data.
     Call<List<CategoryResponseModelItem>> getData();

    @GET("custom_api")
    Call<ProductsModel> getProducts();
}
