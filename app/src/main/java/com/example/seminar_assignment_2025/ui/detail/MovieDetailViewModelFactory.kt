// ui/detail/MovieDetailViewModelFactory.kt (새 파일)

package com.example.seminar_assignment_2025.ui.detail

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.seminar_assignment_2025.data.MovieRepositoryImpl
import com.example.seminar_assignment_2025.network.NetworkModule

// SavedStateHandle을 사용하기 위해 AbstractSavedStateViewModelFactory를 상속
class MovieDetailViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle // ⭐️ 이 handle을 ViewModel에 넘겨줍니다.
    ): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {

            // 1. NetworkModule(object)에서 apiService를 가져옵니다.
            val apiService = NetworkModule.apiService
            // 2. apiService로 Repository를 만듭니다.
            val repository = MovieRepositoryImpl(apiService)

            @Suppress("UNCHECKED_CAST")
            // 3. Repository와 handle을 ViewModel에 주입하며 생성
            return MovieDetailViewModel(repository, handle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}