package com.example.myapplication.DAO;

import com.example.myapplication.Model.CelularContainer;
import com.example.myapplication.Service.Service;
import com.example.myapplication.Utils.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dao {

    private Retrofit retrofit;
    private String baseURL;
    private Service service;

    public Dao() {
        baseURL = "https://api.mercadolibre.com";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Service.class);
    }

    public void getCelular (final ResultListener<CelularContainer> escuchadorDelController){
        Call<CelularContainer> callCelular = service.getListaCelular();

        callCelular.enqueue(new Callback<CelularContainer>() {
            @Override
            public void onResponse(Call<CelularContainer> call, Response<CelularContainer> response) {
                CelularContainer contenedorDeCelulares = response.body();
                escuchadorDelController.finish(contenedorDeCelulares);
            }

            @Override
            public void onFailure(Call<CelularContainer> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

}
