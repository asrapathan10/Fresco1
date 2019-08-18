package com.nirvanaapp.sourcekode.fresco;



import android.app.ProgressDialog;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Hits> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter eAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        recyclerView = (RecyclerView) findViewById(R.id.recyclepost);
        eAdapter = new RecyclerViewAdapter(employeeList);
        ApiService api = RetrofitApi.getApiService();
        Call<Root> rootCall = api.getInfo();
        rootCall.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                pDialog.dismiss();
                if(response.isSuccessful()){
                    employeeList= (ArrayList<Hits>) response.body().getHits();
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);

                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}
