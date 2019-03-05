package com.ex.eynos.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ex.eynos.R;
import com.ex.eynos.activity.DesignDetails;
import com.ex.eynos.activity.FabricDetails;
import com.ex.eynos.model.DesignList;
import com.ex.eynos.model.FabricList;

import java.util.List;

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.ViewHolder>
{
    private List<DesignList> designlist;
    Context context;


    public DesignAdapter(Context context,List<DesignList> designlist)
    {
        this.designlist=designlist;
        this.context=context;
    }


    @NonNull
    @Override
    public DesignAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_row,viewGroup,false);
        return new DesignAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DesignAdapter.ViewHolder viewHolder, int i)
    {
        viewHolder.name.setText(designlist.get(i).getDesigner());
        Glide.with(context).load(designlist.get(i).getImage()).into(viewHolder.img);
        final String image = designlist.get(i).getImage();

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DesignDetails.class);
                i.putExtra("image",image);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return designlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.design_image);
            name = (TextView)itemView.findViewById(R.id.designer_name);
        }
    }
}
