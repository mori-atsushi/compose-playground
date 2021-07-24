package com.example.compose_playground

import com.example.compose_playground.viewmodel.TopViewModel
import com.example.compose_playground.viewmodel.ViewModel
import org.koin.mp.KoinPlatformTools

fun getTopViewModel(): TopViewModel {
    return get()
}

private inline fun <reified T : ViewModel> get(): T {
    val koin = KoinPlatformTools.defaultContext().get()
    return koin.get()
}
