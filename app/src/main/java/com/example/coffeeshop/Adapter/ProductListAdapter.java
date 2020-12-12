package com.example.coffeeshop.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.coffeeshop.ProductDetails;
import com.example.coffeeshop.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import Model.ProductList;
import Model.Products;
import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    Activity context;
    ArrayList<Products> productList;

    public ProductListAdapter(Activity context, ArrayList<Products> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.allproductlist, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Products products = productList.get(position);
        holder.textView1.setText(products.getName());

        double price = products.getPrice();
        int id = products.getProId();
        holder.textView2.setText("Rs."+Double.toString(price));

        RequestOptions requestOptions = new RequestOptions();

        Glide.with(context).setDefaultRequestOptions(requestOptions).load(products.getImg()).into(holder.imageView);

        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ProductDetails.class);
                intent.putExtra("proid",id);
                intent.putExtra("name",products.getName());
                intent.putExtra("price",price);
                intent.putExtra("desc",products.getDesc());
                intent.putExtra("img",products.getImg());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView1,textView2;
        public RelativeLayout relativeLayout;
        public Button details;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textView);
            this.textView2 = (TextView) itemView.findViewById(R.id.textView2);
            this.details = (Button) itemView.findViewById(R.id.btndetails);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
