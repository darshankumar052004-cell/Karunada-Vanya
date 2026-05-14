package com.karunadavanya.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karunadavanya.app.data.local.dao.AlertDao
import com.karunadavanya.app.data.local.dao.WildlifeDao
import com.karunadavanya.app.data.local.entity.AlertEntity
import com.karunadavanya.app.data.local.entity.WildlifeEntity

@Database(
    entities = [AlertEntity::class, WildlifeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alertDao(): AlertDao
    abstract fun wildlifeDao(): WildlifeDao
}
