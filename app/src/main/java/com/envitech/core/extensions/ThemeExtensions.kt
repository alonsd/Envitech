package com.envitech.core.extensions

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.envitech.ui.theme.EnvitechTheme

fun ComponentActivity.envitechContent(content: @Composable () -> Unit){
    setContent {
        EnvitechTheme {
            content()
        }
    }
}