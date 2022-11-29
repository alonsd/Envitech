package com.envitech.core.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.envitech.model.ui_models.DashboardMonitor

@Composable
fun DashboardBottomAppBarSpinner(
    modifier: Modifier = Modifier,
    model: DashboardMonitor,
    onSelectionChanged: () -> Unit
) {

    OutlinedCard(
        modifier = modifier.clickable {
//            expanded = expanded.not()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = model.monitorTypeName,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            DropdownMenu(
                expanded = model.isExpanded,
                onDismissRequest = {
//                    expanded = false
                },
                modifier = Modifier.wrapContentWidth()
            ) {
                model.monitors.forEach { monitor ->

                    DropdownMenuItem(
                        onClick = {
//                            selected = monitor
//                            expanded = false
//                            onSelectionChanged(selected)
                        },
                        text = {
                            Text(
                                text = monitor.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.Start)
                            )
                        },
                    )
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DashboardBottomAppBarSpinnerPreview() {
    MaterialTheme {
        DashboardBottomAppBarSpinner(
            model = DashboardMonitor(
                "Envitech",
                isSelected = true,
                isExpanded = false,
                monitors = listOf(
                    DashboardMonitor.Monitor("Envitech1", 1, false),
                    DashboardMonitor.Monitor("Envitech2", 2, false),
                    DashboardMonitor.Monitor("Envitech3", 3, false),
                )
            ),
            onSelectionChanged = { }
        )
    }
}
