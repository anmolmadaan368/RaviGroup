package com.example.raviworldwidemedicines.Interfaces;

import com.example.raviworldwidemedicines.model.AllProductsByCategory.GetAllProductOfCategories;
import com.example.raviworldwidemedicines.model.CategoryDetailsModel.CategoryResponseModelItem;
import com.example.raviworldwidemedicines.model.products.ProductResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {
    @GET("custom_api/get_all_category.php")

        //on below line we are creating a method to post our data.
     Call<List<CategoryResponseModelItem>> getData();

    @GET("custom_api/product_by_categoryid.php")
    Call<List<GetAllProductOfCategories>> getAllProductsOfCategory(
            @Query("id") int id
    );

    @GET("custom_api/get_all_product.php")
    Call<List<ProductResponseItem>> getProduct(
            @Query("page") int page
            );

}
