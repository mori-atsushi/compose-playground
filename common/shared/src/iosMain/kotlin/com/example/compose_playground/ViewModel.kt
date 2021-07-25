package com.example.compose_playground

import com.example.compose_playground.viewmodel.IOSTopViewModel
import com.example.compose_playground.viewmodel.ViewModel
import org.koin.mp.KoinPlatformTools

fun getTopViewModel(): IOSTopViewModel {
    return IOSTopViewModel(get())
}

private inline fun <reified T : ViewModel> get(): T {
    val koin = KoinPlatformTools.defaultContext().get()
    return koin.get()
}
