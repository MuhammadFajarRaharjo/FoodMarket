package com.belajar.foodmarket.utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.internal.synchronized

class DataStoreSharedPreference(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("Auth")

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: DataStoreSharedPreference? = null

        @InternalCoroutinesApi
        fun getInstance(context: Context): DataStoreSharedPreference {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let { return it }
                val instance = DataStoreSharedPreference(context)
                INSTANCE = instance
                instance
            }
        }
    }

    suspend fun savePreference(key: String, value: String) {
        val datastoreKey = stringPreferencesKey(key)
        context.dataStore.edit { auth ->
            auth[datastoreKey] = value
        }
    }

    fun getPreference(key: String): Flow<String> {
        val datastoreKey = stringPreferencesKey(key)
        return context.dataStore.data.map { preferences ->
            preferences[datastoreKey] ?: "Belum"
        }
    }
}