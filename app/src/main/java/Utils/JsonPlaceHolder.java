package Utils;

import java.util.ArrayList;

import Model.ProductList;
import Model.Products;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @POST("posts")
    Call<ProductList> getProducts();

    @GET("viewDetails")
    Call<Products> getProductDetails(@Query("proId") Integer proId);

}
