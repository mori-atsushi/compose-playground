package com.example.compose_playground.web

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.compose_playground.Greeting
import com.example.compose_playground.di.setupDI
import com.example.compose_playground.network.Sample
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    setupDI()
    renderComposable(rootElementId = "root") {
        App()
    }
}

@Composable
fun App() {
    LaunchedEffect(Unit) {
        Sample.sample()
    }
    val greet = Greeting().greeting()

    Div({
        style {
            width(100.vw)
            height(100.vh)
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
        }
    }) {
        Text(greet)
    }
}