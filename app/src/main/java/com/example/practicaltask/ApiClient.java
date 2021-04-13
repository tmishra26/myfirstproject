package com.example.practicaltask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=50/json
    public static final String BASE_URL = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=50/";
    public static final String BASE_URL_2 = "https://jsonplaceholder.typicode.com/";//users
    private static Retrofit retrofit = null;
    private static Retrofit retrofit1 = null;



    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getPostClient(){
        if (retrofit1==null) {
            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL_2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit1;
    }
}
