package com.example.foodtracker.presentation.ui.adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.R
import com.example.foodtracker.databinding.ProductItemBinding
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.ui.models.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProductAdapter(private val context: Context?) : RecyclerView.Adapter<ProductAdapter.CardHolder>() {

    private val cardList = ArrayList<Product>()
    private val imageLoader: ImageLoader by lazy {
        ImageLoader()
    }
    class CardHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ProductItemBinding.bind(item)

        fun bind(card: Product, context: Context?, imageLoader: ImageLoader) {
            runBlocking {
                launch {
                    imageLoader.loadImage(context, card.image_small_url, binding.cardImage)
                }
            }

            with(binding) {
                title.text = card.name
                cardImage.setImageResource(R.drawable.empty_image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return CardHolder(view)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(cardList[position], this.context, imageLoader)
    }

    fun addCard(card: Product){
        cardList.add(card)
        notifyDataSetChanged()
    }

    fun clear(){
        cardList.clear()
        notifyDataSetChanged()
    }
}