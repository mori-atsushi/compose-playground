package com.example.compose_playground.compose_util

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import com.example.compose_playground.viewmodel.ViewModel
import org.koin.mp.KoinPlatformTools
import kotlin.reflect.KClass

@Composable
actual inline fun <reified T : ViewModel> getViewModel(key: Any?): T {
    return getViewModel(T::class, key)
}

@Composable
@PublishedApi
internal fun <T : ViewModel> getViewModel(
    clazz: KClass<T>,
    key: Any?
): T {
    val tag = "${clazz.qualifiedName}:$currentCompositeKeyHash"
    val context = LocalContext.current
    val activity = remember(context) {
        context.findActivity<ComponentActivity>()
            ?: error("require ComponentActivity")
    }
    val viewModelRegistry = remember(activity) {
        ViewModelProvider(activity).get(ViewModelRegistry::class.java)
    }
    val viewModel = remember(key, viewModelRegistry) {
        getOrCreateViewModel(clazz, tag, viewModelRegistry)
    }
    DisposableEffect(key, viewModel, viewModelRegistry) {
        onDispose {
            if (!activity.isChangingConfigurations) {
                viewModel.clear()
                viewModelRegistry.removeTag(tag)
            }
        }
    }
    return viewModel
}

private fun <T : ViewModel> getOrCreateViewModel(
    clazz: KClass<T>,
    tag: String,
    viewModelRegistry: ViewModelRegistry
): T {
    val previous: T? = viewModelRegistry.getTag(tag)
    if (previous != null) {
        return previous
    }
    val next = createViewModel(clazz)
    viewModelRegistry.setTagIfAbsent(tag, next)
    return next
}

private fun <T : ViewModel> createViewModel(
    clazz: KClass<T>
): T {
    val koin = KoinPlatformTools.defaultContext().get()
    return koin.get(clazz)
}
