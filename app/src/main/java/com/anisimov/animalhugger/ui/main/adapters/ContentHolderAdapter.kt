package com.anisimov.animalhugger.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anisimov.animalhugger.R
import com.anisimov.animalhugger.databinding.ItemAvailableAnimalBinding
import com.anisimov.animalhugger.databinding.ItemContentHolderBinding
import com.anisimov.animalhugger.model.Animal
import com.anisimov.animalhugger.model.Animals
import com.anisimov.animalhugger.ui.main.MainFragment

class ContentHolderAdapter(
    private val availableSpecies: List<String>,
    private val onTabSelected: (selectedSpecies: String) -> Unit,
) : ListAdapter<Animals, ContentHolderAdapter.ViewHolder>(DIFF_CONFIG) {

    companion object {
        private val DIFF_CONFIG = object : DiffUtil.ItemCallback<Animals>() {
            override fun areItemsTheSame(oldItem: Animals, newItem: Animals): Boolean =
                oldItem.species == newItem.species

            override fun areContentsTheSame(oldItem: Animals, newItem: Animals): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            availableSpecies = availableSpecies,
            onTabSelected = this.onTabSelected,
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_content_holder, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animals = getItem(position)

        holder.bind(animals.species, animals.specimens)
    }

    class ViewHolder(
        itemView: View,
        private val availableSpecies: List<String>,
        private val onTabSelected: (selectedSpecies: String) -> Unit,
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemContentHolderBinding.bind(itemView)

        private val adapter = ContentAdapter()

        init {
            binding.contentHolder.adapter = adapter

            availableSpecies.forEach { species ->
                ItemAvailableAnimalBinding.inflate(
                    LayoutInflater.from(itemView.context),
                    binding.availableAnimals,
                    true
                ).root.apply {
                    tag = species
                    text = species

                    setOnClickListener { onTabSelected.invoke(it.tag as String) }
                }
            }
        }

        fun bind(species: String, specimens: List<Animal>) {
            adapter.submitList(specimens)

            binding.availableAnimals.forEach { view ->
                if (view.tag == species) {
                    binding.availableAnimalsScrollView.scrollTo(view.left, 0)
                }
                (view as TextView).setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        if (view.tag == species) {
                            R.color.black
                        } else {
                            R.color.design_fab_shadow_start_color
                        }
                    )
                )
            }
        }

    }

}
