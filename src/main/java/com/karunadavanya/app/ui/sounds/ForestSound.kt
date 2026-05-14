package com.karunadavanya.app.ui.sounds

data class ForestSound(
    val id: Int,
    val name: String,
    val duration: String,
    val icon: String,
    val resId: Int // R.raw resource ID. Set to 0 if placeholder.
)
