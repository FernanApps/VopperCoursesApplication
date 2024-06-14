package di

import data.local.WatchDatabase
import data.local.WatchDatabaseInit
import data.local.WatchProgressDao
import data.local.getRoomDatabase
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.screens.CoursesViewModel

actual val viewModelModule = module {
    singleOf(::CoursesViewModel)
}
actual val platformModule: Module = module {
    single<WatchDatabase> {
        getRoomDatabase(WatchDatabaseInit().getDatabaseBuilder())
    }
}