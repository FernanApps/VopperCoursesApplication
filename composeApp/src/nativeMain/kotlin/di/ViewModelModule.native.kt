package di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.screens.CoursesViewModel

actual val viewModelModule = module {
    singleOf(::CoursesViewModel)
}