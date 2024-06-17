package presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Chapter
import domain.model.Course
import domain.use_cases.GetChaptersUseCase
import domain.use_cases.GetChaptersWithPercentageUseCase
import domain.use_cases.GetCoursesUseCase
import domain.use_cases.GetUserNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoursesViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val getChaptersUseCase: GetChaptersUseCase,
    private val getChaptersWithPercentageUseCase: GetChaptersWithPercentageUseCase,
    private val getUserNameUseCase: GetUserNameUseCase

) : ViewModel() {

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    private val _courses = MutableStateFlow(emptyList<Course>())

    private val _coursesFiltered = MutableStateFlow(emptyList<Course>())
    val courses = _coursesFiltered.asStateFlow()


    private val _currentCourse = MutableStateFlow<Course?>(null)
    val currentCourse = _currentCourse.asStateFlow()


    private val _chapters = MutableStateFlow(emptyList<Chapter>())
    val chapters = _chapters.asStateFlow()


    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()


    init {
        getCourses()
    }

    fun getUserName(){
        viewModelScope.launch {
            _userName.value = getUserNameUseCase()
        }
    }

    private fun getCourses() {
        viewModelScope.launch {
            println("getCourses ??")
            _courses.value = getCoursesUseCase()
            _coursesFiltered.value = _courses.value
        }
    }

    fun onSearchTextChanged(newText: String) {
        _searchText.value = newText
        val filteredList =
            _courses.value.filter { it.title.lowercase().contains(newText.lowercase()) }
        _coursesFiltered.value = filteredList
    }

    fun setCurrentCourse(keyCourse: String) {
        _currentCourse.value = _courses.value.find { it.key == keyCourse }

    }

    private var jobUpdaterPercentage: Job? = null




    override fun onCleared() {
        super.onCleared()
        jobUpdaterPercentage?.cancel()
    }


    fun getChapters() {
        println("getChapters ??")

        if (_currentCourse.value != null) {
            viewModelScope.launch(Dispatchers.Unconfined) {
                val chapters  = getChaptersUseCase(
                    keyCourse = _currentCourse.value!!.key,
                    enabled = _currentCourse.value!!.enabled,
                    total = _currentCourse.value!!.total
                )
                updateChapterWithPercentage(chapters)

            }
        } else {
            _chapters.value = emptyList()
        }

    }

    fun updateChapterWithPercentage(chapters: List<Chapter>) {
        if (_currentCourse.value != null) {
            println("updateChapterWithPercentage")
            jobUpdaterPercentage?.cancel()
            jobUpdaterPercentage = viewModelScope.launch {
                println("jobUpdaterPercentage viewModelScope launch")

                getChaptersWithPercentageUseCase(
                    titleCourse = _currentCourse.value!!.title,
                    chapters = chapters
                ).collect {
                    //println("jobUpdaterPercentage collect $it")
                    _chapters.value = it
                    println("XXx collect " + _chapters.value.filter { it.percentageWatched > 0 })
                }
            }
        }


    }

    fun createNameChapter(title: String, index: Int): String = "$title - $index"

}