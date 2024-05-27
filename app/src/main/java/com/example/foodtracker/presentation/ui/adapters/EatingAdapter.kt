package com.example.foodtracker.presentation.ui.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtracker.R
import com.example.foodtracker.databinding.EatingItemBinding
import com.example.foodtracker.domain.models.EatingDomain
import com.example.foodtracker.domain.models.ProductFromAPI
import com.example.foodtracker.domain.repository.ProductApiRepository
import com.example.foodtracker.domain.usecase.DeleteEating
import com.example.foodtracker.presentation.ImageLoader
import com.example.foodtracker.presentation.ui.models.DailyStat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import java.math.BigDecimal
import java.math.RoundingMode

class EatingAdapter(
    private val productApiRepository: ProductApiRepository,
    private val deleteEating: DeleteEating
) :
    RecyclerView.Adapter<EatingAdapter.EatingHolder>() {
    private val cardList = ArrayList<EatingDomain>()


    class EatingHolder(
        item: View,
        private val adapter: EatingAdapter,
        private val productApiRepository: ProductApiRepository,
        private val deleteEating: DeleteEating
    ) :
        RecyclerView.ViewHolder(item) {
        private val binding = EatingItemBinding.bind(item)

        fun bind(card: EatingDomain) {
            val weight: BigDecimal = card.weight.toBigDecimal()
            val cf: BigDecimal = weight.divide((100).toBigDecimal());
            var productFromAPI: List<ProductFromAPI>?
            runBlocking(Dispatchers.IO) {
                productFromAPI = productApiRepository.findById(card.serverId ?: 0)
            }
            val product = productFromAPI?.get(0)
            with(binding) {
                weightValue.text = card.weight.toString()

                delete.setOnClickListener {
                    deleteEating.execute(card)
                    adapter.deleteEating(card)
                }

                if (product?.energyKcal100g != null) {
                    val energy = product.energyKcal100g.toBigDecimal()
                    energyValue.text =
                        String.format(
                            energy.multiply(cf).setScale(2, RoundingMode.HALF_DOWN).toString()
                        )
                }
                if (product?.proteins100g != null) {
                    val protein = product.proteins100g.toBigDecimal()
                    proteinsValue.text =
                        String.format(
                            protein.multiply(cf).setScale(2, RoundingMode.HALF_DOWN).toString()
                        )
                }
                if (product?.carbohydrates100g != null) {
                    val carbohydrates = product.carbohydrates100g.toBigDecimal()
                    carbohydratesValue.text =
                        String.format(
                            carbohydrates.multiply(cf).setScale(2, RoundingMode.HALF_DOWN)
                                .toString()
                        )
                }
                if (product?.fat100g != null) {
                    val fats = product.fat100g.toBigDecimal()
                    fatsValue.text =
                        String.format(
                            fats.multiply(cf).setScale(2, RoundingMode.HALF_DOWN).toString()
                        )
                }
                title.text = product?.productName
                //imageLoader.loadImage(product?.imageSmallUrl, binding.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EatingHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.eating_item, parent, false)
        return EatingAdapter.EatingHolder(view, this, productApiRepository, deleteEating)
    }

    override fun onBindViewHolder(holder: EatingHolder, position: Int) {
        holder.bind(cardList[position])

    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun deleteEating(eating: EatingDomain) {
        cardList.remove(eating)
        notifyDataSetChanged()
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

            var productFromAPI: List<ProductFromAPI>?
            runBlocking(Dispatchers.IO) {
                productFromAPI = productApiRepository.findById(card.serverId ?: 0)
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