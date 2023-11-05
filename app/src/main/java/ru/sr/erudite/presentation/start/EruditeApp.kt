package ru.sr.erudite.presentation.start

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.sr.erudite.di.authModule
import ru.sr.erudite.di.networkModule

class EruditeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EruditeApp)
            modules(
                networkModule()+authModule()
            )
        }
    }
}