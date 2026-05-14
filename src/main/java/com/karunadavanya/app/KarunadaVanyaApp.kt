package com.karunadavanya.app

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class KarunadaVanyaApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        scheduleAlertExpiryWorker()
    }

    private fun scheduleAlertExpiryWorker() {
        // Run the worker every 1 hour to check for 6-hour expired alerts
        val expiryWorkRequest = PeriodicWorkRequestBuilder<com.karunadavanya.app.worker.AlertExpiryWorker>(
            1, TimeUnit.HOURS
        ).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "AlertExpiryWork",
            ExistingPeriodicWorkPolicy.KEEP,
            expiryWorkRequest
        )
    }
}
