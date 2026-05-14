package com.karunadavanya.app.data.repository

import com.karunadavanya.app.data.local.dao.WildlifeDao
import com.karunadavanya.app.data.local.entity.WildlifeEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WildlifeRepository @Inject constructor(
    private val wildlifeDao: WildlifeDao
) {
    fun getAllWildlife(): Flow<List<WildlifeEntity>> {
        return wildlifeDao.getAllWildlife()
    }

    fun getWildlifeByType(type: String): Flow<List<WildlifeEntity>> {
        return wildlifeDao.getWildlifeByType(type)
    }

    suspend fun insertAll(wildlifeList: List<WildlifeEntity>) {
        wildlifeDao.insertAll(wildlifeList)
    }

    suspend fun getCount(): Int {
        return wildlifeDao.getCount()
    }
}
