package com.example.seminar_assignment_2025.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MovieDetailScreen(
    movieId: Int,
    // (나중에 ViewModel에서 영화 정보를 가져와야 함)
    // viewModel: MovieDetailViewModel = viewModel()
) {
    // (movieId를 사용해 ViewModel에게 영화 정보를 요청하는 로직 필요)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "영화 상세 화면\n(ID: $movieId)",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}