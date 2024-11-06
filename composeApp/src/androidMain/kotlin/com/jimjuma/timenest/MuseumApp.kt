package com.jimjuma.timenest

import android.app.Application
import com.jimjuma.timenest.di.initKoin

class MuseumApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
