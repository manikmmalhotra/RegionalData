package com.example.regionaldata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.regionaldata.Model.ApiClient;
import com.example.regionaldata.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiClient apiClient;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient=new ApiClient();
        recyclerView=findViewById(R.id.recyclerthing);


        Call<List<Model>> call = apiClient.getApiinterface().getCountry();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                CountryAdapter countryAdapter=new CountryAdapter(getApplicationContext(),response.body());
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(countryAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
            }


            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}