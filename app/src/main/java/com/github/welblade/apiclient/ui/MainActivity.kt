package com.github.welblade.apiclient.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.welblade.apiclient.api.MyRetrofit
import com.github.welblade.apiclient.databinding.ActivityMainBinding
import com.github.welblade.apiclient.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        setupRecycleView()
    }
    private fun setupRecycleView(){
        activityMainBinding.rvProducts.layoutManager = LinearLayoutManager(this)
        getData()
    }
    private fun getData(){
        val call: Call<List<Product>> =
            MyRetrofit.instance?.getProductApi() as Call<List<Product>>
        call.enqueue(
            object: Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    val adapter = ProductAdapter(this@MainActivity, response.body() as List<Product>)
                    activityMainBinding.rvProducts.adapter = adapter
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }
}