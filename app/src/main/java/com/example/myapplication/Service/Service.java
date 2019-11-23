package com.example.myapplication.Service;

import com.example.myapplication.Model.CelularContainer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET ("/sites/MLA/search?q=celulares#json")
    Call <CelularContainer> getListaCelular();


}
