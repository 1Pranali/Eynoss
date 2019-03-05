package com.ex.eynos.network;

import com.ex.eynos.model.Datum;
import com.ex.eynos.model.Designn;
import com.ex.eynos.model.Eynos;
import com.ex.eynos.model.Fabricc;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClientService
{
    @POST("newapp/saralapp/public/api/login/{email_address}/{password}")
    Call<Eynos> getLoginData(@Path("email_address")String email, @Path("password")String password);

    @FormUrlEncoded
    @POST("newapp/saralapp/public/api/login")
    Call<Eynos> getData(@Field("email_address") String email, @Field("password")String password);

    @GET("newapp/saralapp/public/api/get-fabrics")
    Call<Fabricc> getFabric();

    @GET("newapp/saralapp/public/api/get-designs")
    Call<Designn> getDesign();
}
