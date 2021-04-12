package com.example.practicaltask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    @GET("json")
    Call<ImName> getNames();

}
