package domain.use_cases

import data.local.WatchProgressRepository
import domain.model.Chapter
import domain.repository.CourseRepository


class GetChaptersUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke(
        keyCourse: String,
        enabled: Int,
        total: Int
    ): List<Chapter> = repository.getChapters(keyCourse, enabled = enabled, total)
}

class GetChaptersWithPercentageUseCase(private val courseRepository: CourseRepository,
                                       private val watchProgressRepository: WatchProgressRepository ) {
    suspend operator fun invoke(
        keyCourse: String,
        enabled: Int,
        total: Int
    ): List<Chapter> {
        return courseRepository.getChapters(keyCourse, enabled = enabled, total)
    }
}