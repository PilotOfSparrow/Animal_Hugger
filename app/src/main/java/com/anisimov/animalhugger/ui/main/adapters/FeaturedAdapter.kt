package com.anisimov.animalhugger.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anisimov.animalhugger.R
import com.anisimov.animalhugger.databinding.ItemFeaturedBinding

class FeaturedAdapter : ListAdapter<String, FeaturedAdapter.ViewHolder>(DIFF_CONFIG) {

    companion object {
        private val DIFF_CONFIG = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
                areContentsTheSame(oldItem, newItem)

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_featured, parent, false)
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemFeaturedBinding.bind(itemView)

        fun bind(featuredAnimalName: String) {
            binding.animalName.text = featuredAnimalName
        }

    }

}

