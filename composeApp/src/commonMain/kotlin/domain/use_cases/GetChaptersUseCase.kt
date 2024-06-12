package domain.use_cases

import domain.model.Chapter
import domain.repository.CourseRepository


class GetChaptersUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke(
        keyCourse: String,
        enabled: Int,
        total: Int
    ): List<Chapter> = repository.getChapters(keyCourse, enabled = enabled, total)
}