package com.example.foodtracker.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.R
import com.example.foodtracker.databinding.EatingCardBinding
import com.example.foodtracker.databinding.ProductItemBinding
import com.example.foodtracker.presentation.ui.models.AdditionCard
import com.example.foodtracker.presentation.ui.models.ICard
import com.example.foodtracker.presentation.ui.models.EatingCard
import com.example.foodtracker.presentation.ui.models.Product

class EatingCardAdapter : RecyclerView.Adapter<EatingCardAdapter.CardHolder>() {

    private val cardList = ArrayList<Product>()

    class CardHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ProductItemBinding.bind(item)

        fun bind(card: Product) {
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
        holder.bind(cardList[position])
    }

    fun addCard(card: Product){
        cardList.add(card)
        notifyDataSetChanged()
    }

}