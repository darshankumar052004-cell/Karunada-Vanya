package com.karunadavanya.app.ui.alerts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karunadavanya.app.data.local.entity.AlertEntity
import com.karunadavanya.app.databinding.ItemAlertBinding
import java.util.concurrent.TimeUnit

class AlertAdapter : ListAdapter<AlertEntity, AlertAdapter.AlertViewHolder>(AlertDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        val binding = ItemAlertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlertViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlertViewHolder(private val binding: ItemAlertBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(alert: AlertEntity) {
            binding.tvAnimalName.text = alert.animalType
            binding.tvLocation.text = alert.location
            binding.tvNotes.text = alert.notes

            // Set emoji based on type
            binding.tvAnimalEmoji.text = when(alert.animalType) {
                "Elephant" -> "🐘"
                "Leopard" -> "🐆"
                "Tiger" -> "🐅"
                else -> "🐾"
            }

            // Calculate time ago
            val timeDiff = System.currentTimeMillis() - alert.timestamp
            val hoursAgo = TimeUnit.MILLISECONDS.toHours(timeDiff)
            val minutesAgo = TimeUnit.MILLISECONDS.toMinutes(timeDiff) % 60
            binding.tvTimeAgo.text = if (hoursAgo > 0) "${hoursAgo}h ago" else "${minutesAgo}m ago"

            // Calculate expiry (6 hours = 21600000 ms)
            val sixHoursMillis = 6 * 60 * 60 * 1000L
            val expiryTime = alert.timestamp + sixHoursMillis
            val remainingMillis = expiryTime - System.currentTimeMillis()
            
            if (remainingMillis > 0) {
                val remainingHours = TimeUnit.MILLISECONDS.toHours(remainingMillis)
                val remainingMins = TimeUnit.MILLISECONDS.toMinutes(remainingMillis) % 60
                binding.tvExpiryCountdown.text = "Expires in ${remainingHours}h ${remainingMins}m"
            } else {
                binding.tvExpiryCountdown.text = "Expired"
            }
        }
    }

    class AlertDiffCallback : DiffUtil.ItemCallback<AlertEntity>() {
        override fun areItemsTheSame(oldItem: AlertEntity, newItem: AlertEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AlertEntity, newItem: AlertEntity): Boolean {
            return oldItem == newItem
        }
    }
}
