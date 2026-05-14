package com.karunadavanya.app.di

import android.content.Context
import androidx.room.Room
import com.karunadavanya.app.data.local.AppDatabase
import com.karunadavanya.app.data.local.dao.AlertDao
import com.karunadavanya.app.data.local.dao.WildlifeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "karunada_vanya_db"
        )
        // Note: For pre-seeding wildlife data, we will use an asset DB or a callback here.
        .fallbackToDestructiveMigration()
        .build()
    }

    @Provides
    @Singleton
    fun provideAlertDao(database: AppDatabase): AlertDao {
        return database.alertDao()
    }

    @Provides
    @Singleton
    fun provideWildlifeDao(database: AppDatabase): WildlifeDao {
        return database.wildlifeDao()
    }
}
