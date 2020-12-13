package com.example.coffeeshop;

import Model.ProductList;
import Model.Products;
import Utils.Constants;
import Utils.JsonPlaceHolder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;

import com.example.coffeeshop.Adapter.ProductListAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class AllProductList extends AppCompatActivity {

    private Retrofit retrofit;
    private JsonPlaceHolder jsonPlaceHolder;
    private Gson gson;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product_list);

        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(Constants.HTTP.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getProducts();
    }

    private void getProducts() {
        Call<List<Products>> products = jsonPlaceHolder.getProducts();
        products.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {

                if (response.isSuccessful()) {
                    List<Products> body = response.body();
                    ProductListAdapter adapter = new ProductListAdapter(AllProductList.this, body);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    System.out.println(response.body());
                }
                System.out.println("");

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                System.out.println(t);
            }
        });

    }

}
