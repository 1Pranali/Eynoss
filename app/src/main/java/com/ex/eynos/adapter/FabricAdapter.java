package com.ex.eynos.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ex.eynos.R;
import com.ex.eynos.activity.FabricDetails;
import com.ex.eynos.model.FabricList;

import java.util.List;

public class FabricAdapter extends RecyclerView.Adapter<FabricAdapter.ViewHolder>
{
    private List<FabricList> fabriclist;
    Context context;

    public FabricAdapter(Context context,List<FabricList> fabriclist)
    {
        this.fabriclist=fabriclist;
        this.context=context;
    }

    public void setMovieList(List<FabricList> mm)
    {
        this.fabriclist=mm;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FabricAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fabric_row,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final FabricAdapter.ViewHolder viewHolder, int i)
    {
        viewHolder.t1.setText(fabriclist.get(i).getType());
        viewHolder.t2.setText(fabriclist.get(i).getVendor());
        viewHolder.t3.setText(fabriclist.get(i).getCode());
        viewHolder.t4.setText(String.valueOf(fabriclist.get(i).getAvailability()));
        Glide.with(context).load(fabriclist.get(i).getImage()).into(viewHolder.img);

        // store values
        final String fabric_type = fabriclist.get(i).getType();
        final String fabric_code = fabriclist.get(i).getCode();
        final String fabric_available = fabriclist.get(i).getAvailability();
        final String fabric_vendor = fabriclist.get(i).getVendor();
        final int fabric_id = fabriclist.get(i).getFabId();
        final String fabric_date = fabriclist.get(i).getDate();
        final String fabric_stock = fabriclist.get(i).getStock();
        final String image = fabriclist.get(i).getImage();

        viewHolder.img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Bundle b = new Bundle();
                Intent i = new Intent(context, FabricDetails.class);
                i.putExtra("fab_id",fabric_id);
                i.putExtra("type",fabric_type);
                i.putExtra("code",fabric_code);
                i.putExtra("vendor",fabric_vendor);
                i.putExtra("availability",fabric_available);
                i.putExtra("date",fabric_date);
                i.putExtra("stock",fabric_stock);
                i.putExtra("image",image);
                context.startActivity(i);


            }
        });
    }

    @Override
    public int getItemCount()
    {
        return fabriclist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView t1,t2,t3,t4;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);



            img = (ImageView)itemView.findViewById(R.id.fabric_image);
            t1 = (TextView)itemView.findViewById(R.id.fabrictype);
            t2 = (TextView)itemView.findViewById(R.id.fabricvendor);
            t3 = (TextView)itemView.findViewById(R.id.fabricode);
            t4 = (TextView)itemView.findViewById(R.id.fabricavailability);
        }
    }
}

