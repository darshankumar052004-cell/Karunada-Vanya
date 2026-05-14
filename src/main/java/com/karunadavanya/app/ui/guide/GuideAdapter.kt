package com.karunadavanya.app.ui.guide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karunadavanya.app.databinding.ItemGuideBinding

class GuideAdapter : ListAdapter<GuideScenario, GuideAdapter.GuideViewHolder>(GuideDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val binding = ItemGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GuideViewHolder(private val binding: ItemGuideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(scenario: GuideScenario) {
            binding.tvScenarioTitle.text = scenario.title
            binding.tvScenarioAdvice.text = scenario.advice

            // Update UI based on expanded state
            if (scenario.isExpanded) {
                binding.llExpandedContent.visibility = View.VISIBLE
                binding.ivExpandIcon.rotation = 180f
            } else {
                binding.llExpandedContent.visibility = View.GONE
                binding.ivExpandIcon.rotation = 0f
            }

            // Handle accordion click
            binding.clHeader.setOnClickListener {
                scenario.isExpanded = !scenario.isExpanded
                notifyItemChanged(adapterPosition)
            }
        }
    }

    class GuideDiffCallback : DiffUtil.ItemCallback<GuideScenario>() {
        override fun areItemsTheSame(oldItem: GuideScenario, newItem: GuideScenario): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GuideScenario, newItem: GuideScenario): Boolean {
            return oldItem == newItem
        }
    }
}
