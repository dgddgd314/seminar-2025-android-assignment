package com.example.seminar_assignment_2025.ui

import com.example.seminar_assignment_2025.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    // 1. Column: 위(검색창)에서 아래(내용)로 쌓기 위해 사용
    Column(
        // modifier.fillMaxSize() : Scaffold가 준 공간(바텀바 제외)을 꽉 채움
        // .padding(16.dp) : 화면 좌우에 여백을 줌
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp)) // 상단 여백

        // 2. 검색창 (TextField)
        OutlinedTextField(
            value = "", // 지금은 아무것도 연결 안 함 (가짜)
            onValueChange = {}, // 지금은 아무것도 연결 안 함 (가짜)
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("영화 검색...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            singleLine = true
        )

        // 3. 비어있을 때 화면 (EmptyState)
        // 검색창 밑의 남은 공간을 모두 차지하고, 그 안에서 정중앙에 배치
        EmptyState(modifier = Modifier.weight(1f))
    }
}

@Composable
fun EmptyState(modifier: Modifier = Modifier) {
    // Box: 내부 아이템들을 정렬하기 편함
    Box(
        modifier = modifier.fillMaxSize(), // 부모(Column)가 준 공간을 꽉 채움
        contentAlignment = Alignment.Center // 내용물을 정중앙에 배치
    ) {
        // Column: 아이콘과 텍스트를 세로로 나열
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // 1. 영화 아이콘
            Icon(
                // R.drawable.movie_svgrepo_com (아래 '해야 할 일' 참고)
                painter = painterResource(id = R.drawable.movie_svgrepo_com),
                contentDescription = "Movie Icon",
                modifier = Modifier.size(80.dp),
                tint = Color.Gray // 아이콘 색상을 회색으로
            )
            Spacer(modifier = Modifier.height(16.dp))

            // 2. 텍스트
            Text(
                "영화를 검색해보세요",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "상단 검색 바를 통해\n원하는 영화를 찾아보세요",
                color = Color.Gray,
                textAlign = TextAlign.Center // 여러 줄일 때 중앙 정렬
            )
        }
    }
}