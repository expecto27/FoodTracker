package com.example.foodtracker.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.R
import com.example.foodtracker.databinding.EatingCardBinding
import com.example.foodtracker.presentation.ui.models.EatingCard

class EatingCardAdapter : RecyclerView.Adapter<EatingCardAdapter.CardHolder>() {

    private val cardList = ArrayList<EatingCard>()

    class CardHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = EatingCardBinding.bind(item)

        fun bind(card: EatingCard) = with(binding) {
            title.text = card.title
            cardImage.setImageResource(card.imageId)
            cardView.setCardBackgroundColor(card.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.eating_card, parent, false)
        return CardHolder(view)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(cardList[position])
    }

    fun addCard(card: EatingCard){
        cardList.add(card)
        notifyDataSetChanged()
    }
}