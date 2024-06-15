package domain.use_cases

import domain.repository.AppPreferencesRepository
import domain.repository.CourseRepository


class GetUserNameUseCase(private val repository: AppPreferencesRepository) {
    suspend operator fun invoke() = repository.getUserName()
}