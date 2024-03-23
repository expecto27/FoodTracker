package com.example.foodtracker.presentation.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.databinding.EatingCardBinding
import com.example.foodtracker.presentation.ui.models.EatingCard

class EatingCardAdapter : RecyclerView.Adapter<EatingCardAdapter.CardHolder>() {
    class CardHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = EatingCardBinding.bind(item)
        fun bind(card: EatingCard) = with(binding) {
            title.text = card.title
            cardImage.setImageResource(card.imageId)
            cardView.setCardBackgroundColor(card.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        TODO("Not yet implemented")
    }
}