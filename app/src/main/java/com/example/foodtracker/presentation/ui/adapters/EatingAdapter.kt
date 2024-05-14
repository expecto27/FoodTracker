package com.example.foodtracker.presentation.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.R
import com.example.foodtracker.databinding.EatingItemBinding
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.ui.models.DailyStat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import java.math.BigDecimal

class EatingAdapter(
    private val productApiRepository: ProductApiRepository,
    private val imageLoader: ImageLoader
) :
    RecyclerView.Adapter<EatingAdapter.EatingHolder>() {
    private val cardList = ArrayList<EatingDomain>()


    class EatingHolder(
        item: View,
        private val productApiRepository: ProductApiRepository,
        private val imageLoader: ImageLoader
    ) :
        RecyclerView.ViewHolder(item) {
        private val binding = EatingItemBinding.bind(item)

        fun bind(card: EatingDomain) {
            val weight: BigDecimal = card.weight.toBigDecimal()
            val cf: BigDecimal = weight.divide((100).toBigDecimal());
            var productFromAPICall: Response<List<ProductFromAPI>>
            runBlocking(Dispatchers.IO) {
                productFromAPICall = productApiRepository.findById(card.serverId ?: 0).execute()
            }
            var productFromAPI: List<ProductFromAPI>? = null
            if (productFromAPICall.isSuccessful) {
                productFromAPI = productFromAPICall.body()
            }
            val product = productFromAPI?.get(0)
            with(binding) {
                weightValue.text = card.weight.toString()

                if (product?.energyKcal100g != null) {
                    val energy = product.energyKcal100g.toBigDecimal()
                    energyValue.text =
                        String.format(energy.multiply(cf).toString())
                }
                if (product?.proteins100g != null) {
                    val protein = product.proteins100g.toBigDecimal()
                    proteinsValue.text =
                        String.format(protein.multiply(cf).toString())
                }
                if (product?.carbohydrates100g != null) {
                    val carbohydrates = product.carbohydrates100g.toBigDecimal()
                    carbohydratesValue.text =
                        String.format(carbohydrates.multiply(cf).toString())
                }
                if (product?.fat100g != null) {
                    val fats = product.fat100g.toBigDecimal()
                    fatsValue.text =
                        String.format(fats.multiply(cf).toString())
                }
                title.text = product?.productName
                //imageLoader.loadImage(product?.imageSmallUrl, binding.image)
                //Todo: фото продуктов на главной выглядит убого
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EatingHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.eating_item, parent, false)
        return EatingAdapter.EatingHolder(view, productApiRepository, imageLoader)
    }

    override fun onBindViewHolder(holder: EatingHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun addCard(card: EatingDomain) {
        cardList.add(card)
        notifyDataSetChanged()
    }

    fun calculateTotal(): DailyStat {
        var totalEnergy = 0.0
        var totalProteins = 0.0
        var totalCarbohydrates = 0.0
        var totalFats = 0.0

        cardList.forEach { card ->
            val weight = card.weight.toBigDecimal()
            val cf = weight.divide((100).toBigDecimal())

            var productFromAPICall: Response<List<ProductFromAPI>>
            runBlocking(Dispatchers.IO) {
                productFromAPICall = productApiRepository.findById(card.serverId ?: 0).execute()
            }
            var productFromAPI: List<ProductFromAPI>? = null
            if (productFromAPICall.isSuccessful) {
                productFromAPI = productFromAPICall.body()
            }
            val product = productFromAPI?.get(0)

            if (product?.energyKcal100g != null) {
                val energy = product.energyKcal100g.toBigDecimal()
                totalEnergy += energy.multiply(cf).toDouble()
            }
            if (product?.proteins100g != null) {
                val protein = product.proteins100g.toBigDecimal()
                totalProteins += protein.multiply(cf).toDouble()
            }
            if (product?.carbohydrates100g != null) {
                val carbohydrates = product.carbohydrates100g.toBigDecimal()
                totalCarbohydrates += carbohydrates.multiply(cf).toDouble()
            }
            if (product?.fat100g != null) {
                val fats = product.fat100g.toBigDecimal()
                totalFats += fats.multiply(cf).toDouble()
            }
        }

        return DailyStat(totalEnergy, totalProteins, totalFats, totalCarbohydrates)
    }

}