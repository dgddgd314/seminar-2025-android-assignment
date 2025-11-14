package com.example.seminar_assignment_2025.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

interface MovieRepository {
    suspend fun searchByTitle(query: String): List<Movie>
    suspend fun getGenreName(id: Int): String
    suspend fun getMovieDetail(id: Int): MovieDetail

}

data class MovieDetail(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val voteAverage: Double,
    val posterPath: String,
    val backdropPath: String,
    val overview: String,
    val genres: List<String>, // ⭐️ DTO와 달리 장르 '이름' 리스트
    val runtime: Int,
    val tagline: String
)


@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("genre_ids") val genreIds: List<Int>,
    @SerialName("backdrop_path") val backdropPath: String?,
    val overview: String?,
    val popularity: Double
)

@Serializable
data class MovieDetailDto(
    val id: Int,
    val title: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("backdrop_path") val backdropPath: String?,
    val overview: String?,

    // ⭐️ 중요: 상세 API는 ID가 아닌, 장르 객체 목록(List<GenreDto>)을 줍니다.
    val genres: List<GenreDto>,

    val runtime: Int?, // ⭐️ (예) 148 (분)
    val tagline: String? // ⭐️ (예) "Your mind is the scene of the crime."
)

@Serializable
data class GenreDto(
    val id: Int,
    val name: String
)

@Serializable
data class GenreListDto(
    val genres: List<GenreDto>
)
