package com.example.seminar_assignment_2025.network

import MovieSearchResponse
import com.example.seminar_assignment_2025.data.GenreListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApiService {

    // 'search/movie' 엔드포인트에 GET 요청
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String // 쿼리 파라미터로 'query={검색어}' 추가
        // 'api_key'는 Interceptor가 알아서 추가해줄 것입니다.
    ): MovieSearchResponse

    // 'genre/movie/list' 엔드포인트에 GET 요청
    @GET("genre/movie/list")
    suspend fun getGenres(): GenreListDto
}