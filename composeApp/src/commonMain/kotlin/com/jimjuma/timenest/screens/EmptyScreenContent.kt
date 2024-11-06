package com.jimjuma.timenest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import timenest.composeapp.generated.resources.Res
import timenest.composeapp.generated.resources.no_data_available

@OptIn(ExperimentalResourceApi::class)
@Composable
fun EmptyScreenContent(
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .size(88.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.Blue,
                modifier = Modifier.size(40.dp)
            )
        }
        Text(stringResource(Res.string.no_data_available))
    }
}
