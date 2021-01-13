package com.alison.qualeaboa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alison.qualeaboa.R;
import com.alison.qualeaboa.activity.PartyActivity;
import com.alison.qualeaboa.model.Estab;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EstabsAdapter extends RecyclerView.Adapter<EstabsAdapter.MyViewHolder> {

    private List<Estab> estabs;
    private Context context;

    public EstabsAdapter(List<Estab> estabs, Context context) {
        this.estabs = estabs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item, parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PartyActivity.class);
                i.putExtra("tv_name", estabs.get(viewHolder.getAdapterPosition()).getName());

                context.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(estabs.get(position).getName());
        holder.tv_address.setText(estabs.get(position).getAddress());
        holder.tv_description.setText(estabs.get(position).getDescription());
        Picasso.with(context).load(estabs.get(position).getImage()).into(holder.img_name);

    }

    @Override
    public int getItemCount() {
        return estabs.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_address, tv_description;
        ImageView img_name;
        RelativeLayout container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_description = itemView.findViewById(R.id.tv_description);
            img_name = itemView.findViewById(R.id.img_name);
            container = itemView.findViewById(R.id.container);

        }
    }
}
