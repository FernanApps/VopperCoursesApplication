package di

import data.local.WatchDatabase
import data.local.WatchDatabaseInit
import data.local.WatchProgressDao
import data.local.getRoomDatabase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.screens.CoursesViewModel

actual val viewModelModule = module {
    viewModelOf(::CoursesViewModel)
}
actual val platformModule = module {
    single<WatchDatabase> {
        getRoomDatabase(WatchDatabaseInit(get()).getDatabaseBuilder())
    }
}