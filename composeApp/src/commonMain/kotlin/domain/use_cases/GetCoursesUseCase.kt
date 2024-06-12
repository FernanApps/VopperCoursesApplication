package domain.use_cases

import domain.repository.CourseRepository


class GetCoursesUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke() = repository.getCourses()
}