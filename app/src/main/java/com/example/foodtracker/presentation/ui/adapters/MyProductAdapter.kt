package com.example.foodtracker.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.R
import com.example.foodtracker.databinding.MyProdCardBinding
import com.example.foodtracker.presentation.ui.models.Product

class MyProductAdapter : RecyclerView.Adapter<MyProductAdapter.ProductHolder>() {
    private val cardList = ArrayList<Product>()
    class ProductHolder(item: View) : RecyclerView.ViewHolder(item){
        private val binding = MyProdCardBinding.bind(item)
        fun bind(card: Product){
            val perGramm = "/100g"
            with(binding){
                title.text = card.name
                calories.text = "${card.calories} kcal"
                protein.text = "${card.protein} $perGramm"
                fat.text = "${card.fat} $perGramm"
                carbohydrates.text = "${card.carbohydrates} $perGramm"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.my_prod_card, parent, false)
        return MyProductAdapter.ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
    fun addCard(card: Product){
        cardList.add(card)
        notifyDataSetChanged()
    }
}