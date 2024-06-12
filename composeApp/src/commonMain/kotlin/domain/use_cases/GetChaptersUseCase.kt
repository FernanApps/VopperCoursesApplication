package domain.use_cases

import domain.repository.CourseRepository


class GetChaptersUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke() = repository.getChapters()
}