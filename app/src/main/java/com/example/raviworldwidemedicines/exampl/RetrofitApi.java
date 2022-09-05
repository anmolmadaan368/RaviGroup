package com.example.raviworldwidemedicines.exampl;

import com.example.raviworldwidemedicines.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitApi {
    @GET("api_data.php")

        //on below line we are creating a method to post our data.
    Call<List<Model>> getData();


}
