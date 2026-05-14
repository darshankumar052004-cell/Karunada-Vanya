package com.karunadavanya.app.data.repository

import com.karunadavanya.app.data.local.dao.AlertDao
import com.karunadavanya.app.data.local.entity.AlertEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlertRepository @Inject constructor(
    private val alertDao: AlertDao
) {
    fun getActiveAlerts(): Flow<List<AlertEntity>> {
        return alertDao.getActiveAlerts()
    }

    suspend fun insertAlert(alert: AlertEntity) {
        alertDao.insertAlert(alert)
    }

    suspend fun expireOldAlerts(expiryTimeMillis: Long) {
        alertDao.expireOldAlerts(expiryTimeMillis)
    }
}
