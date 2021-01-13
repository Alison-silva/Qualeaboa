package com.alison.qualeaboa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alison.qualeaboa.R;
import com.alison.qualeaboa.adapter.EstabsAdapter;
import com.alison.qualeaboa.adapter.PartyAdapter;
import com.alison.qualeaboa.api.ApiClient;
import com.alison.qualeaboa.api.ApiInterface;
import com.alison.qualeaboa.model.Estab;
import com.alison.qualeaboa.model.Party;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartyActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Party> parties;
    private PartyAdapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        String name = getIntent().getExtras().getString("tv_name");
        TextView txt_local = findViewById(R.id.tv_name);
        txt_local.setText(name);

        fetchParty(name);
    }

    public void fetchParty(String key){
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Party>> call = apiInterface.getEvents(key);

        call.enqueue(new Callback<List<Party>>() {
            @Override
            public void onResponse(Call<List<Party>> call, Response<List<Party>> response) {
                parties = response.body();
                adapter = new PartyAdapter(parties, PartyActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Party>> call, Throwable t) {
                Toast.makeText(PartyActivity.this, "Error on :" + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}