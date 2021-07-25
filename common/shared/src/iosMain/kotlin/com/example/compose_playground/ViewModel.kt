package com.example.compose_playground

import com.example.compose_playground.viewmodel.IOSListViewModel
import com.example.compose_playground.viewmodel.ViewModel
import org.koin.mp.KoinPlatformTools

fun getListViewModel(): IOSListViewModel {
    return IOSListViewModel(get())
}

private inline fun <reified T : ViewModel> get(): T {
    val koin = KoinPlatformTools.defaultContext().get()
    return koin.get()
}
