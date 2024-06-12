package di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.screens.CoursesViewModel

actual val viewModelModule = module {
    viewModelOf(::CoursesViewModel)
}