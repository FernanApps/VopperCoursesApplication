package vopper.academy.courses

import di.KoinInitializer
import android.app.Application

class VopperCoursesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}