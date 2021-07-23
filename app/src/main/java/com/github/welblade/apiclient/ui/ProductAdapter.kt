package com.github.welblade.apiclient.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.welblade.apiclient.databinding.ItemProductBinding
import com.github.welblade.apiclient.model.Product

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
       )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    inner class ProductViewHolder(private val item: ItemProductBinding):RecyclerView.ViewHolder(item.root){
        fun bind(product: Product){
            item.tvPrName.text = product.prname
            item.tvPrPrice.text = product.prprice
            Glide.with(context).load(product.primage).into(item.ivPrImage)
        }
    }
}