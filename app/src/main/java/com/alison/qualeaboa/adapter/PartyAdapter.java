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
import com.alison.qualeaboa.activity.DetailPartyActivity;
import com.alison.qualeaboa.activity.PartyActivity;
import com.alison.qualeaboa.model.Party;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.MyViewHolder> {

    private List<Party> parties;
    private Context context;

    public PartyAdapter(List<Party> parties, Context context) {
        this.parties = parties;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_party, parent,false);
        final PartyAdapter.MyViewHolder viewHolder = new PartyAdapter.MyViewHolder(v);

        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailPartyActivity.class);
                i.putExtra("tv_party", parties.get(viewHolder.getAdapterPosition()).getParty());
                i.putExtra("tv_local", parties.get(viewHolder.getAdapterPosition()).getLocal());
                i.putExtra("tv_timer", parties.get(viewHolder.getAdapterPosition()).getTimer());
                i.putExtra("tv_day", parties.get(viewHolder.getAdapterPosition()).getDay());
                i.putExtra("tv_price", parties.get(viewHolder.getAdapterPosition()).getPrice());
                i.putExtra("tv_description", parties.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("img_name", parties.get(viewHolder.getAdapterPosition()).getImage());

                context.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_party.setText(parties.get(position).getParty());
        holder.tv_local.setText(parties.get(position).getLocal());
        Picasso.with(context).load(parties.get(position).getImage()).into(holder.img_name);
    }

    @Override
    public int getItemCount() {
        return parties.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_party, tv_local;
        ImageView img_name;
        RelativeLayout container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_party = itemView.findViewById(R.id.tv_party);
            tv_local = itemView.findViewById(R.id.tv_local);
            img_name = itemView.findViewById(R.id.img_name);
            container = itemView.findViewById(R.id.container);
        }
    }
}
