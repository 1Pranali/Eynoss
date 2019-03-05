package com.ex.eynos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ex.eynos.R;
import com.ex.eynos.model.DesignList;
import com.ex.eynos.model.FabricList;

import java.util.List;

public class FabricImageAdapter extends RecyclerView.Adapter<FabricImageAdapter.ViewHolder>
{
    private List<FabricList> fabriclist;
    Context context;

    public FabricImageAdapter(Context context,List<FabricList> fabriclist)
    {
        this.fabriclist=fabriclist;
        this.context=context;
    }
    @NonNull
    @Override
    public FabricImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fabric_images,viewGroup,false);
        return new FabricImageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FabricImageAdapter.ViewHolder viewHolder, int i)
    {

        Glide.with(context).load(fabriclist.get(i).getImage()).into(viewHolder.i);
    }

    @Override
    public int getItemCount() {
        return fabriclist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView i ;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            i = (ImageView)itemView.findViewById(R.id.show_fabric_images);
        }
    }
}
