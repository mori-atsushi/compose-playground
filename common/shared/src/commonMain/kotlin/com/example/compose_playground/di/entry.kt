package com.example.compose_playground.di

import org.koin.core.context.startKoin

fun setupDI() {
    startKoin {
        modules(module)
    }
}
