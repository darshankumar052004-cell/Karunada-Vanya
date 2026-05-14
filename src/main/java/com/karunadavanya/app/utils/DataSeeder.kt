package com.karunadavanya.app.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.karunadavanya.app.data.local.entity.WildlifeEntity
import com.karunadavanya.app.data.repository.WildlifeRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSeeder @Inject constructor(
    @ApplicationContext private val context: Context,
    private val wildlifeRepository: WildlifeRepository
) {
    suspend fun seedDatabaseIfNeeded() {
        withContext(Dispatchers.IO) {
            if (wildlifeRepository.getCount() == 0) {
                try {
                    val inputStream = context.assets.open("wildlife_data.json")
                    val size = inputStream.available()
                    val buffer = ByteArray(size)
                    inputStream.read(buffer)
                    inputStream.close()

                    val json = String(buffer, Charsets.UTF_8)
                    val listType = object : TypeToken<List<WildlifeEntity>>() {}.type
                    val wildlifeList: List<WildlifeEntity> = Gson().fromJson(json, listType)

                    wildlifeRepository.insertAll(wildlifeList)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
