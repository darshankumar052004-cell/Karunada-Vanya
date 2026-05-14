package com.karunadavanya.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karunadavanya.app.data.local.entity.WildlifeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WildlifeDao {
    @Query("SELECT * FROM wildlife ORDER BY name ASC")
    fun getAllWildlife(): Flow<List<WildlifeEntity>>

    @Query("SELECT * FROM wildlife WHERE type = :type ORDER BY name ASC")
    fun getWildlifeByType(type: String): Flow<List<WildlifeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(wildlifeList: List<WildlifeEntity>)

    @Query("SELECT COUNT(*) FROM wildlife")
    suspend fun getCount(): Int
}
