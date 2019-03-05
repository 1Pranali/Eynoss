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

public class DesignImageAdapter extends RecyclerView.Adapter<DesignImageAdapter.ViewHolder>
{
    private List<DesignList> designlist;
    Context context;

    public DesignImageAdapter(Context context,List<DesignList> designlist)
    {
        this.designlist=designlist;
        this.context=context;
    }
    @NonNull
    @Override
    public DesignImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_images,viewGroup,false);
        return new DesignImageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DesignImageAdapter.ViewHolder viewHolder, int i)
    {
        Glide.with(context).load(designlist.get(i).getImage()).into(viewHolder.i);

    }

    @Override
    public int getItemCount() {
        return designlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView i ;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            i = (ImageView)itemView.findViewById(R.id.show_design_images);

        }
    }
}
