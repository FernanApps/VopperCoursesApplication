package di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.local.AppPreferencesRepositoryImpl
import data.local.WatchProgressDao
import data.local.WatchProgressRepository
import data.local.datastore.createDataStore
import data.remote.CourseRepositoryImp
import domain.repository.AppPreferencesRepository
import domain.repository.CourseRepository
import domain.use_cases.GetCoursesUseCase
import domain.use_cases.GetChaptersUseCase
import domain.use_cases.GetUserNameUseCase
import domain.use_cases.GetChaptersWithPercentageUseCase

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single { "Hello world!" }


    single<CourseRepository> { CourseRepositoryImp() }
    //singleOf(::CourseRepositoryImp)


    single<WatchProgressRepository> {
        WatchProgressRepository(get())
    }

    singleOf(::GetChaptersWithPercentageUseCase)

    // DataStore
    single<DataStore<Preferences>> {
        createDataStore()
    }
    single<AppPreferencesRepository> {
        AppPreferencesRepositoryImpl(get())
    }

    singleOf(::GetCoursesUseCase)
    singleOf(::GetChaptersUseCase)
    singleOf(::GetUserNameUseCase)


}