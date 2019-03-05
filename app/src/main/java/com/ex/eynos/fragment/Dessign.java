package com.ex.eynos.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.eynos.R;
import com.ex.eynos.adapter.DesignAdapter;
import com.ex.eynos.adapter.FabricAdapter;
import com.ex.eynos.model.DesignList;
import com.ex.eynos.model.Designn;
import com.ex.eynos.model.Fabricc;
import com.ex.eynos.network.ClientApi;
import com.ex.eynos.network.ClientService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dessign extends Fragment
{
    RecyclerView recyclerview ;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.dessign_list, container, false);
        recyclerview = (RecyclerView)rootView.findViewById(R.id.designlist);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerview.setLayoutManager(layoutManager);
        getDesignDetails();

        return rootView;
    }

    public void getDesignDetails()
    {
        ClientService call = ClientApi.getData().create(ClientService.class);
        Call<Designn> data = call.getDesign();

        data.enqueue(new Callback<Designn>()
        {
            @Override
            public void onResponse(Call<Designn> call, Response<Designn> response)
            {
                List<DesignList> res = response.body().getData();
                recyclerview.setAdapter(new DesignAdapter(getContext(),res));

            }

            @Override
            public void onFailure(Call<Designn> call, Throwable t) {

            }
        });
    }
}
