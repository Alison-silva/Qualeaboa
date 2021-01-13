package com.alison.qualeaboa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alison.qualeaboa.R;
import com.squareup.picasso.Picasso;

public class DetailPartyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_party);

        String party = getIntent().getExtras().getString("tv_party");
        String local = getIntent().getExtras().getString("tv_local");
        String timer = getIntent().getExtras().getString("tv_timer");
        String day = getIntent().getExtras().getString("tv_day");
        String price = getIntent().getExtras().getString("tv_price");
        String description = getIntent().getExtras().getString("tv_description");
        String image = getIntent().getExtras().getString("img_name");

        TextView tv_party = findViewById(R.id.tv_party);
        TextView tv_local = findViewById(R.id.tv_local);
        TextView tv_timer = findViewById(R.id.tv_timer);
        TextView tv_day = findViewById(R.id.tv_day);
        TextView tv_price = findViewById(R.id.tv_price);
        TextView tv_description = findViewById(R.id.tv_description);
        ImageView img_name = findViewById(R.id.img_name);

        tv_party.setText(party);
        tv_local.setText(local);
        tv_timer.setText(timer);
        tv_day.setText(day);
        tv_price.setText(price);
        tv_description.setText(description);
        Picasso.with(this).load(image).into(img_name);

    }
}