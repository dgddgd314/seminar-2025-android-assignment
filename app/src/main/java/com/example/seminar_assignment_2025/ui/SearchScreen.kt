package com.example.seminar_assignment_2025.ui

import com.example.seminar_assignment_2025.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seminar_assignment_2025.search.SearchViewModel
import androidx.compose.ui.text.input.ImeAction

@Composable
fun SearchScreen(modifier: Modifier = Modifier,
                 viewModel: SearchViewModel = viewModel()) {

    val searchQuery by viewModel.searchQuery.collectAsState()
    val recentSearches by viewModel.recentSearches.collectAsState()

    // (키보드 컨트롤러: 검색 후 키보드를 숨길 때 사용)
    val keyboardController = LocalSoftwareKeyboardController.current

    // 1. Column: 위(검색창)에서 아래(내용)로 쌓기 위해 사용
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // 2. 검색창 (TextField)
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.onQueryChanged(it)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("영화 검색...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            singleLine = true,
            // (2) '가위표(X)' 버튼 (스펙)
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { viewModel.onQueryChanged("") }) { // 검색창 비우기
                        Icon(Icons.Default.Clear, contentDescription = "Clear search")
                    }
                }
            },
            // (3) 키보드의 '검색' 버튼 설정
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search // 키보드 액션 버튼을 '검색'으로 변경
            ),
            // (4) '검색' 버튼을 눌렀을 때 실행할 행동
            keyboardActions = KeyboardActions(
                onSearch = {
                    // ViewModel에 '검색어 저장'을 '보고'
                    viewModel.saveSearchQuery(searchQuery)
                    // 키보드 숨기기
                    keyboardController?.hide()
                }
            )
        )

        // 3. 비어있을 때 화면 (EmptyState)
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