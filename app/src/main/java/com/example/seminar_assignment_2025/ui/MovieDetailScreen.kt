package com.example.seminar_assignment_2025.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seminar_assignment_2025.data.Movie

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MovieDetailScreen(
    movieId: Int,
    onBackClick: () -> Unit, // (NavGenerate로부터 받음)
    viewModel: MovieDetailViewModel = viewModel()
) {
    val movie by viewModel.movie.collectAsState()

    LaunchedEffect(key1 = movieId) {
        viewModel.fetchMovieById(movieId)
    }

    Scaffold(
        // 3. 투명한 TopAppBar (뒤로 가기 버튼용)
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) { // (전달받은 onBackClick 함수 연결)
                        Icon(Icons.Default.ArrowBack, "Back", tint = Color.White)
                    }
                },
                // (배경을 투명하게, 아이콘을 흰색으로)
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->

        // 4. 영화 정보가 로드되기 전 (null)이면 로딩 스피너 표시
        if (movie == null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        // 5. 영화 정보가 로드되면, 스크롤 가능한 Column 표시
        else {
            val loadedMovie = movie!!
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // (Scaffold가 알려준 패딩 적용)
                    .verticalScroll(rememberScrollState()) // (전체 스크롤)
            ) {
                // --- (1) 상단 헤더 (Backdrop + Poster + Title) ---
                MovieHeader(movie = loadedMovie)

                // --- (2) 메인 콘텐츠 (장르, 요약, 인기도) ---
                Column(modifier = Modifier.padding(16.dp)) {
                    GenreChips(genreIds = loadedMovie.genre_ids)

                    Spacer(modifier = Modifier.height(24.dp))

                    Text("Summary", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(loadedMovie.overview ?: "No summary.", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(24.dp))

                    Text("Popularity", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(loadedMovie.popularity.toString(), style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun MovieHeader(movie: Movie) {
    // TODO
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun GenreChips(genreIds: List<Int>) {
    // TODO
}