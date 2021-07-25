package com.example.compose_playground.web.compose_ui.widget

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.foundation.layout.Row
import org.jetbrains.compose.common.material.Button
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Alignment
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun SearchBox(
    value: String,
    onValueChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextInput(
            value = value,
            attrs = {
                onChange {
                    onValueChange(it.value)
                }
            }
        )
        Button(
            onClick = onSubmit
        ) {
            Text("Submit")
        }
    }
}
