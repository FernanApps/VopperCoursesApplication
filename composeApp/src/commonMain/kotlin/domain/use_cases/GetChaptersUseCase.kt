package domain.use_cases

import data.local.WatchProgressRepository
import domain.model.Chapter
import domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map


class GetChaptersUseCase(private val repository: CourseRepository) {
    suspend operator fun invoke(
        keyCourse: String,
        enabled: Int,
        total: Int
    ): List<Chapter> = repository.getChapters(keyCourse, enabled = enabled, total)
}

class GetChaptersWithPercentageUseCase(private val watchProgressRepository: WatchProgressRepository) {
    operator fun invoke(
        titleCourse: String,
        chapters: List<Chapter>
    ): Flow<List<Chapter>> {
        val watched = watchProgressRepository.getAllWatchProgressAsFlow()
        return watched.map { watchedList ->
            chapters.map { chapter ->
                val nameChapter = createNameChapter(titleCourse, chapter.index)
                val findWatched = watchedList.find { watched ->
                    watched.mediaId == watchProgressRepository.createMediaId(nameChapter)
                }
                if (findWatched == null) {
                    chapter
                } else {
                    chapter.copy(percentageWatched = findWatched.getProgressPercentage())
                }
            }
        }
    }

    private fun createNameChapter(title: String, index: Int): String = "$title - $index"

}