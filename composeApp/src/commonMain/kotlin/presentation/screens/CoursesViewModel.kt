package presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Chapter
import domain.model.Course
import domain.use_cases.GetChaptersUseCase
import domain.use_cases.GetCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoursesViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val getChaptersUseCase: GetChaptersUseCase

): ViewModel() {


    private val _courses = MutableStateFlow(emptyList<Course>())
    val courses = _courses.asStateFlow()

    private val _chapters = MutableStateFlow(emptyList<Chapter>())
    val chapters = _chapters.asStateFlow()


    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()


    init {
        getCourses()
    }

    private fun getCourses(){
        viewModelScope.launch {
            _courses.value = getCoursesUseCase()
        }
    }
    fun onSearchTextChanged(newText: String) {
        _searchText.value = newText
    }




    private fun getChapters(){
        viewModelScope.launch {
            _chapters.value = getChaptersUseCase()
        }
    }

}