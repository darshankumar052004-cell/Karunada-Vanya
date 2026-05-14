package com.karunadavanya.app.utils

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForestMediaPlayer @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private var mediaPlayer: MediaPlayer? = null
    private var currentSoundResId: Int? = null

    fun playSound(soundResId: Int) {
        if (currentSoundResId == soundResId && mediaPlayer?.isPlaying == true) {
            pauseSound()
            return
        }

        stopSound()
        
        mediaPlayer = MediaPlayer.create(context, soundResId).apply {
            setOnCompletionListener {
                stopSound()
            }
            start()
        }
        currentSoundResId = soundResId
    }

    fun pauseSound() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
            }
        }
    }

    fun stopSound() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
        }
        mediaPlayer = null
        currentSoundResId = null
    }
}
