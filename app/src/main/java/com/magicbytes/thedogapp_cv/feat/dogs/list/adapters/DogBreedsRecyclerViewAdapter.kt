package com.magicbytes.thedogapp_cv.feat.dogs.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.databinding.ItemListDogBredBinding
import com.squareup.picasso.Picasso

class DogBreedsRecyclerViewAdapter : RecyclerView.Adapter<DogBreedsRecyclerViewAdapter.ViewHolder>() {

    var listItems: List<DogBreed> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onBreedSelected: (breed: DogBreed) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListDogBredBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding) {
            if (it > -1 && it < listItems.size) {
                onBreedSelected(listItems[it])
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount() = listItems.size

    inner class ViewHolder(private val binding: ItemListDogBredBinding, onClickListener: (adapterPosition: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onClickListener(adapterPosition)
            }
        }

        fun bind(item: DogBreed) {
            binding.breedNameTextView.text = item.name
            Picasso.get().load(item.image.url).into(binding.breedImageView)
        }
    }
}
