package com.example.compose_playground.di

import com.example.compose_playground.network.GitHubApi
import com.example.compose_playground.network.GitHubApiImpl
import com.example.compose_playground.network.createHttpClient
import com.example.compose_playground.viewmodel.TopViewModel
import org.koin.dsl.module

val module = module {
    single { createHttpClient() }
    single<GitHubApi> { GitHubApiImpl(get()) }

    factory { TopViewModel(get()) }
}
