package di

import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            //logger(PrintLogger())
            modules(appModule, viewModelModule, platformModule)
        }
    }
}