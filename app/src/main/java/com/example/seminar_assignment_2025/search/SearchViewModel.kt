package com.example.seminar_assignment_2025.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // UI가 "글자 바뀌었어!"라고 호출할 함수
    fun onQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery

        // 검색 API
    }
}