package com.example.regionaldata;

import com.example.regionaldata.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("asia/")
    Call<List<Model>> getCountry();

}
