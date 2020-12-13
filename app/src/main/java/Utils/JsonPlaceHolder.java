package Utils;

import java.util.ArrayList;
import java.util.List;

import Model.Orders;
import Model.ProductList;
import Model.Products;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @POST("posts")
    Call<List<Products>> getProducts();

    @GET("setorder")
    Call<Orders> getProductDetails(@Query("proId") Integer proId, @Query("qty") Integer qty);

}
