package domain.repository

import domain.model.Chapter
import domain.model.Course

interface CourseRepository{
    suspend fun getCourses(): List<Course>
    suspend fun getChapters(keyCourse: String, enabled: Int, total: Int): List<Chapter>
}