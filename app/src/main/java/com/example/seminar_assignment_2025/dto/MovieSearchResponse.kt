// MovieSearchResponse.kt (새 파일 또는 Dto 파일에 추가)

import com.example.seminar_assignment_2025.data.MovieDto
import kotlinx.serialization.Serializable

@Serializable
data class MovieSearchResponse(
    val results: List<MovieDto>
    // TMDB API는 page, total_pages 등 다른 정보도 주지만, 지금은 results만 필요
)