package com.example.seminar_assignment_2025.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

interface MovieRepository {
    suspend fun searchByTitle(query: String): List<Movie>
    suspend fun getGenreName(id: Int): String
}

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
data class GenreDto(
    val id: Int,
    val name: String
)

@Serializable
data class GenreListDto(
    val genres: List<GenreDto>
)
