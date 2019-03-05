package com.ex.eynos.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi
{
    //base url
    public static final String BASE_URL="http://192.168.0.101:14654/";

    // singleton class object
    public static Retrofit service = null;

    public static Retrofit getData()
    {
        if(service==null)
        {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return service;
    }
}
