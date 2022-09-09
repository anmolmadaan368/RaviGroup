package com.example.raviworldwidemedicines.Interfaces;

import com.example.raviworldwidemedicines.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("api_data.php")

        //on below line we are creating a method to post our data.
    Call<List<Model>> getData();


}
