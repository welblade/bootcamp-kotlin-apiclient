package com.github.welblade.apiclient.api

import com.github.welblade.apiclient.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("getdata.php")
    fun getProductApi():Call<List<Product>>
}