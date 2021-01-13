package com.alison.qualeaboa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.alison.qualeaboa.R;
import com.alison.qualeaboa.adapter.EstabsAdapter;
import com.alison.qualeaboa.api.ApiClient;
import com.alison.qualeaboa.api.ApiInterface;
import com.alison.qualeaboa.databinding.ActivityHomeBinding;
import com.alison.qualeaboa.model.Estab;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Estab> estabs;
    private EstabsAdapter adapter;
    private ApiInterface apiInterface;
    ActivityHomeBinding binding;

    //por enquanto apenas testes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchNames("");
    }

    public void fetchNames(String key){

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Estab>> call = apiInterface.getLocals(key);

        call.enqueue(new Callback<List<Estab>>() {
            @Override
            public void onResponse(Call<List<Estab>> call, Response<List<Estab>> response) {
                binding.progress.setVisibility(View.GONE);
                estabs = response.body();
                adapter = new EstabsAdapter(estabs, HomeActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Estab>> call, Throwable t) {
                binding.progress.setVisibility(View.GONE);
                Toast.makeText(HomeActivity.this, "Error on :" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Procure um local: ");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchNames(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchNames(newText);
                return false;
            }
        });
        return true;
    }
}//