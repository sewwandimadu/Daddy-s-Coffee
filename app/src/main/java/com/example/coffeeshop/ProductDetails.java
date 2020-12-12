 package com.example.coffeeshop;

import Model.ProductList;
import Model.Products;
import Utils.Constants;
import Utils.JsonPlaceHolder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.coffeeshop.Adapter.ProductListAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

 public class ProductDetails extends AppCompatActivity {

     private Retrofit retrofit;
     private JsonPlaceHolder jsonPlaceHolder;
     private Gson gson;
     private String name,des,img;
     private int proid;
     private double price;
     AppCompatTextView txtname,txtprice,txtdesc;
     AppCompatImageView txtimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        proid = getIntent().getIntExtra("proid",0);
        name =  getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price",0);
        des =  getIntent().getStringExtra("desc");
        img =  getIntent().getStringExtra("img");

        txtname = findViewById(R.id.txtname);
        txtprice = findViewById(R.id.price);
        txtdesc = findViewById(R.id.desc);
        txtimg = findViewById(R.id.img1);

        txtname.setText(name);
        txtprice.setText("Rs."+Double.toString(price));
        txtdesc.setText(des);



        Picasso.get().load(img).into(txtimg);

//        gson = new GsonBuilder().setLenient().create();
//        retrofit = new Retrofit.Builder().baseUrl(Constants.HTTP.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
//        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

       // getProductsDetails(proid);


    }

     private void getProductsDetails(String id) {

         int pid = Integer.parseInt(id);

         Call<Products> products = jsonPlaceHolder.getProductDetails(pid);
         products.enqueue(new Callback<Products >() {
             @Override
             public void onResponse(Call<Products> call, Response<Products> response) {

                 if (response.isSuccessful()) {
                     Products body = response.body();
                     System.out.println(body);
                 }
                 System.out.println("");

             }

             @Override
             public void onFailure(Call<Products> call, Throwable t) {

                 System.out.println(t);
             }
         });

     }
}
