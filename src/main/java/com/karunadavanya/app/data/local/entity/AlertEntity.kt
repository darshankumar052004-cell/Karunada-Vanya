package com.karunadavanya.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alerts")
data class AlertEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val animalType: String,
    val location: String,
    val notes: String,
    val timestamp: Long,
    val isExpired: Boolean = false
)
