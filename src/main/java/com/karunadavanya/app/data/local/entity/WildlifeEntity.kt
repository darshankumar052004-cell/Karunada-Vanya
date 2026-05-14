package com.karunadavanya.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wildlife")
data class WildlifeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val type: String, // "Flora", "Fauna", "Birds"
    val habitat: String,
    val description: String,
    val funFact: String,
    val threatLevel: String,
    val imageName: String
)
