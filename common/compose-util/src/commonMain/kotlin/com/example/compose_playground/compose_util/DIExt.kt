package com.example.compose_playground.compose_util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.mp.KoinPlatformTools

@Composable
inline fun <reified T : Any> get(
    key: Any?,
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T = remember(key, qualifier, parameters) {
    val koin = KoinPlatformTools.defaultContext().get()
    koin.get(qualifier, parameters)
}
