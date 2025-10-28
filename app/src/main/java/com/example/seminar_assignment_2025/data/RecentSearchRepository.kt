package com.example.seminar_assignment_2025.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "recent_searches")

interface RecentSearchRepository {
    val recentSearchesFlow: Flow<List<String>>

    /** 새 검색어 목록에 추가 (중복 시 맨 위로) */
    suspend fun addSearchQuery(query: String)

    /** 특정 검색어를 목록에서 삭제 */
    suspend fun deleteSearchQuery(query: String)

    /** 모든 최근 검색어를 삭제 */
    suspend fun clearAllSearchQueries()
}