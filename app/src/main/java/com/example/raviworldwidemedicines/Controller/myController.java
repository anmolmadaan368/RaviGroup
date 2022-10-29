package com.example.raviworldwidemedicines.Controller;


import com.example.raviworldwidemedicines.Interfaces.RetrofitApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myController {

    private static myController myController;
    private static final String Category_Details_Base_URL="https://raviworldwidemedicines.com/";
    private static Retrofit retrofit;
    public myController(){
        Gson gson= new GsonBuilder()
                .setLenient()
                .create();

        retrofit=  new Retrofit.Builder()
                .baseUrl(Category_Details_Base_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized myController getInstance(){
        if(myController == null){
            myController = new myController();
        }
        return myController;
    }

    public  RetrofitApi getCategoryDetails_Api(){
        return retrofit.create(RetrofitApi.class);
    }
}
