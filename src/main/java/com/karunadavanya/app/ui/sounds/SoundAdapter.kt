package com.karunadavanya.app.ui.sounds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karunadavanya.app.databinding.ItemSoundBinding

class SoundAdapter(
    private val onPlayClicked: (ForestSound) -> Unit
) : ListAdapter<ForestSound, SoundAdapter.SoundViewHolder>(SoundDiffCallback()) {

    // Track currently playing ID for UI state
    var currentlyPlayingId: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val binding = ItemSoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        holder.bind(getItem(position), currentlyPlayingId)
    }

    inner class SoundViewHolder(private val binding: ItemSoundBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sound: ForestSound, playingId: Int?) {
            binding.tvSoundName.text = sound.name
            binding.tvDuration.text = sound.duration
            binding.tvSoundIcon.text = sound.icon

            val isPlaying = sound.id == playingId
            if (isPlaying) {
                binding.btnPlayPause.text = "Stop"
                binding.btnPlayPause.setIconResource(android.R.drawable.ic_media_pause)
            } else {
                binding.btnPlayPause.text = "Play"
                binding.btnPlayPause.setIconResource(android.R.drawable.ic_media_play)
            }

            binding.btnPlayPause.setOnClickListener {
                onPlayClicked(sound)
            }
        }
    }

    class SoundDiffCallback : DiffUtil.ItemCallback<ForestSound>() {
        override fun areItemsTheSame(oldItem: ForestSound, newItem: ForestSound): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ForestSound, newItem: ForestSound): Boolean {
            return oldItem == newItem
        }
    }
}
