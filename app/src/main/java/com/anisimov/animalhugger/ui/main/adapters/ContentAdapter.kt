package com.anisimov.animalhugger.ui.main.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anisimov.animalhugger.R
import com.anisimov.animalhugger.databinding.ItemContentBinding
import com.anisimov.animalhugger.model.Animal
import com.anisimov.animalhugger.ui.main.MainFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class ContentAdapter :
    ListAdapter<Animal, ContentAdapter.ContentViewHolder>(DIFF_CONFIG) {

    companion object {
        private val DIFF_CONFIG = object : DiffUtil.ItemCallback<Animal>() {
            override fun areItemsTheSame(
                oldItem: Animal,
                newItem: Animal
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Animal,
                newItem: Animal
            ): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        )

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemContentBinding.bind(itemView)

        fun bind(animal: Animal) {
            binding.title.text = animal.name
            binding.subtitle.text = animal.description

            Glide
                .with(itemView.context)
                .load(animal.imageUrl)
                .into(binding.image)
        }

    }

}
