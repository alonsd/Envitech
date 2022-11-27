package com.envitech.ui.screens.dashboard.state.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.envitech.core.ui.EnvitechButtonWithText

@Composable
fun EnvitechBottomAppBar() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            EnvitechButtonWithText(text = "alon1") {

            }
            EnvitechButtonWithText(text = "alon2") {

            }
            EnvitechButtonWithText(text = "alon3") {

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnvitechBottomAppBarPreview() {
    EnvitechBottomAppBar()
}