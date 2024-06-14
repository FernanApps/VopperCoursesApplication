package di

import data.local.WatchProgressDao
import data.local.WatchProgressRepository
import data.remote.CourseRepositoryImp
import domain.repository.CourseRepository
import domain.use_cases.GetCoursesUseCase
import domain.use_cases.GetChaptersUseCase
import domain.use_cases.GetChaptersWithPercentageUseCase

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single { "Hello world!" }


    single<CourseRepository> { CourseRepositoryImp() }
    //singleOf(::CourseRepositoryImp)
    singleOf(::GetCoursesUseCase)
    singleOf(::GetChaptersUseCase)


    single<WatchProgressRepository> {
        WatchProgressRepository(get())
    }
    singleOf(::GetChaptersWithPercentageUseCase)

}