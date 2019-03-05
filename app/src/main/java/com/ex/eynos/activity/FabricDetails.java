package com.ex.eynos.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ex.eynos.R;
import com.ex.eynos.adapter.DesignImageAdapter;
import com.ex.eynos.adapter.FabricAdapter;
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

public class FabricDetails extends AppCompatActivity
{
    RecyclerView recyclerview ;
    ImageView fab_img;
    TextView fab_type,fab_code,fab_available,fab_stock,fab_vendor,fab_date;
    String image,type,code,vendor,date,fabavail,fabstock;
    int available,stock;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fabric_detail_code);
        initviews();

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerview.setLayoutManager(layoutManager);
        designImages();
        getFabricDetails();
        setFabricDetails();


    }

    public void initviews()
    {
        fab_img = (ImageView)findViewById(R.id.fab_detail_img);
        fab_type = (TextView)findViewById(R.id.fabrictype);
        fab_code = (TextView)findViewById(R.id.fabricode);
        fab_available = (TextView)findViewById(R.id.fabricavailability);
        fab_stock = (TextView)findViewById(R.id.fabricstock);
        fab_vendor = (TextView)findViewById(R.id.fabricvendor);
        fab_date = (TextView)findViewById(R.id.fabricdate);
        recyclerview = (RecyclerView)findViewById(R.id.show_design);
    }

    public void getFabricDetails()
    {
        Intent i = getIntent();
        image = i.getStringExtra("image");
        Glide.with(this).load(image).into(fab_img);
//        byte[] arr = i.getByteArrayExtra("image");
//        Bitmap map = BitmapFactory.decodeByteArray(arr,arr.length);

        type = i.getStringExtra("type");
        code = i.getStringExtra("code");
        vendor = i.getStringExtra("vendor");
        date = i.getStringExtra("date");

        fabavail = i.getStringExtra("availability");
        fabstock = i.getStringExtra("stock");

//       available = Integer.parseInt(fabavail);
//        stock = Integer.parseInt(fabstock);



    }
    public void setFabricDetails()
    {
        fab_type.setText(type);
        fab_code.setText(code);
        fab_vendor.setText(vendor);
        fab_date.setText(date);
       fab_stock.setText(fabstock);
        fab_available.setText(fabavail);
    }

    public void designImages()
    {
        ClientService call = ClientApi.getData().create(ClientService.class);
        Call<Designn> data = call.getDesign();

        data.enqueue(new Callback<Designn>() {
            @Override
            public void onResponse(Call<Designn> call, Response<Designn> response)
            {
                List<DesignList> res = response.body().getData();
                recyclerview.setAdapter(new DesignImageAdapter(FabricDetails.this,res));

            }

            @Override
            public void onFailure(Call<Designn> call, Throwable t) {

            }
        });
    }
}
