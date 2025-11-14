package com.example.seminar_assignment_2025.network

import com.example.seminar_assignment_2025.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

// 네트워크 객체들을 관리하는 싱글톤
object NetworkModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    // 1. 로깅 인터셉터
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    // 2. OkHttpClient (AuthInterceptor 포함)
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .addInterceptor(loggingInterceptor)
        .build()

    // 3. Kotlinx-Serialization Json 객체
    private val json = Json {
        ignoreUnknownKeys = true
    }

    // 4. Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    // 5. TmdbApiService (우리가 사용할 최종 객체)
    val apiService: TmdbApiService = retrofit.create(TmdbApiService::class.java)
}