package com.karunadavanya.app.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.karunadavanya.app.data.repository.AlertRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class AlertExpiryWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val alertRepository: AlertRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            // Expire alerts older than 6 hours
            val sixHoursInMillis = 6 * 60 * 60 * 1000L
            val expiryThreshold = System.currentTimeMillis() - sixHoursInMillis
            
            alertRepository.expireOldAlerts(expiryThreshold)
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
