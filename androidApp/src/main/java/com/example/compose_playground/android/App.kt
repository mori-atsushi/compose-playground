package com.example.compose_playground.android

import android.app.Application
import com.example.compose_playground.di.setupDI

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDI()
    }
}
