package com.karunadavanya.app.ui.guide

data class GuideScenario(
    val id: Int,
    val title: String,
    val advice: String,
    var isExpanded: Boolean = false
)
