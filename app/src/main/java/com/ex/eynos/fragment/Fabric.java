package com.ex.eynos.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.eynos.R;
import com.ex.eynos.adapter.FabricAdapter;
import com.ex.eynos.model.FabricList;
import com.ex.eynos.model.Fabricc;
import com.ex.eynos.network.ClientApi;
import com.ex.eynos.network.ClientService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fabric extends Fragment
{
    RecyclerView recyclerview ;
    FabricAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fabric_list, container, false);
        recyclerview = (RecyclerView)rootView.findViewById(R.id.fabriclist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        getFabricDetails();

        return rootView;
    }

    public void getFabricDetails()
    {
        ClientService call = ClientApi.getData().create(ClientService.class);
        Call<Fabricc> data = call.getFabric();

        data.enqueue(new Callback<Fabricc>() {
            @Override
            public void onResponse(Call<Fabricc> call, Response<Fabricc> response)
            {
                List<FabricList> res = response.body().getData();
                Log.d("tag"," List"+res.size());
                recyclerview.setAdapter(new FabricAdapter(getContext(),res));

            }

            @Override
            public void onFailure(Call<Fabricc> call, Throwable t) {

            }
        });
    }


}
