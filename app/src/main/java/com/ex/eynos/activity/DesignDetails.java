package com.ex.eynos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ex.eynos.R;
import com.ex.eynos.adapter.FabricImageAdapter;
import com.ex.eynos.model.DesignList;
import com.ex.eynos.model.Designn;
import com.ex.eynos.model.FabricList;
import com.ex.eynos.model.Fabricc;
import com.ex.eynos.network.ClientApi;
import com.ex.eynos.network.ClientService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DesignDetails extends AppCompatActivity
{
    RecyclerView recyclerview ;
    ImageView img;
    String image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_detail_code);
        initviews();
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerview.setLayoutManager(layoutManager);
        getImageDetails();
        fabricImages();
    }


    public void initviews()
    {
        img=  (ImageView)findViewById(R.id.showDesignImage);
        recyclerview=  (RecyclerView)findViewById(R.id.show_fabric);

    }

    public void getImageDetails()
    {
        Intent i = getIntent();
        image = i.getStringExtra("image");
        Glide.with(this).load(image).into(img);
    }

    public void fabricImages()
    {
        ClientService call = ClientApi.getData().create(ClientService.class);
        Call<Fabricc> data = call.getFabric();

        data.enqueue(new Callback<Fabricc>() {
            @Override
            public void onResponse(Call<Fabricc> call, Response<Fabricc> response)
            {
                List<FabricList> res = response.body().getData();
                recyclerview.setAdapter(new FabricImageAdapter(DesignDetails.this,res));

            }

            @Override
            public void onFailure(Call<Fabricc> call, Throwable t) {

            }
        });
    }
}
