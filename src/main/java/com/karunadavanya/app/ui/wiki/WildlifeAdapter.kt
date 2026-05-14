package com.karunadavanya.app.ui.wiki

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karunadavanya.app.data.local.entity.WildlifeEntity
import com.karunadavanya.app.databinding.ItemWildlifeBinding

class WildlifeAdapter : ListAdapter<WildlifeEntity, WildlifeAdapter.WildlifeViewHolder>(WildlifeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WildlifeViewHolder {
        val binding = ItemWildlifeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WildlifeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WildlifeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WildlifeViewHolder(private val binding: ItemWildlifeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(wildlife: WildlifeEntity) {
            binding.tvSpeciesName.text = wildlife.name
            binding.tvHabitat.text = wildlife.habitat
            binding.tvBackSpeciesName.text = wildlife.name
            binding.tvDescription.text = wildlife.description
            binding.tvFunFact.text = wildlife.funFact
            binding.tvThreatLevel.text = wildlife.threatLevel

            // Load placeholder/drawable based on imageName mapping
            val context = binding.root.context
            val resId = context.resources.getIdentifier(wildlife.imageName, "drawable", context.packageName)
            if (resId != 0) {
                binding.ivWildlifePhoto.setImageResource(resId)
            } else {
                binding.ivWildlifePhoto.setImageResource(android.R.drawable.ic_menu_gallery)
            }
        }
    }

    class WildlifeDiffCallback : DiffUtil.ItemCallback<WildlifeEntity>() {
        override fun areItemsTheSame(oldItem: WildlifeEntity, newItem: WildlifeEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WildlifeEntity, newItem: WildlifeEntity): Boolean {
            return oldItem == newItem
        }
    }
}
