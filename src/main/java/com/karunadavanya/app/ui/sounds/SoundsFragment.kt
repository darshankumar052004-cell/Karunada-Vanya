package com.karunadavanya.app.ui.sounds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karunadavanya.app.databinding.FragmentSoundsBinding
import dagger.hilt.android.AndroidEntryPoint

import android.widget.Toast
import com.karunadavanya.app.utils.ForestMediaPlayer
import javax.inject.Inject

@AndroidEntryPoint
class SoundsFragment : Fragment() {

    private var _binding: FragmentSoundsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var mediaPlayer: ForestMediaPlayer
    
    private lateinit var adapter: SoundAdapter

    // Dummy data using generated WAV files in res/raw
    private val soundsList = listOf(
        ForestSound(1, "Indian Roller Call", "0:04", "🐦", com.karunadavanya.app.R.raw.roller),
        ForestSound(2, "Elephant Rumble", "0:04", "🐘", com.karunadavanya.app.R.raw.elephant),
        ForestSound(3, "Tiger Growl", "0:04", "🐅", com.karunadavanya.app.R.raw.tiger),
        ForestSound(4, "Night Forest Ambience", "0:05", "🌙", com.karunadavanya.app.R.raw.ambience),
        ForestSound(5, "Morning Bird Chorus", "0:04", "🌅", com.karunadavanya.app.R.raw.chorus)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSoundsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        adapter = SoundAdapter { clickedSound ->
            if (adapter.currentlyPlayingId == clickedSound.id) {
                // It's playing, so pause/stop it
                mediaPlayer.stopSound()
                adapter.currentlyPlayingId = null
            } else {
                // Play new sound
                mediaPlayer.stopSound()
                adapter.currentlyPlayingId = clickedSound.id
                
                if (clickedSound.resId != 0) {
                    mediaPlayer.playSound(clickedSound.resId)
                } else {
                    Toast.makeText(requireContext(), "Placeholder! Add actual mp3 to res/raw", Toast.LENGTH_SHORT).show()
                }
            }
            adapter.notifyDataSetChanged()
        }
        
        binding.rvSounds.adapter = adapter
        adapter.submitList(soundsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer.stopSound()
        _binding = null
    }
}
