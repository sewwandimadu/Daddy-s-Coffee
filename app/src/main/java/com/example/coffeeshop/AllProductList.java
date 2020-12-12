package com.example.coffeeshop;

import Model.Products;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.coffeeshop.Adapter.ProductListAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product_list);

        List<Products> myListData = new ArrayList<>();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ProductListAdapter adapter = new ProductListAdapter(AllProductList.this,myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
