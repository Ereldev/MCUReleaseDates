package com.ereldev.mcureleasedates.android.common.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ereldev.mcureleasedates.android.R

@Composable
fun ErrorWithRetry(message: String, modifier: Modifier = Modifier, onRetry: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            color = Color.Gray,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onRetry) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ErrorWithRetryPreview() {
    ErrorWithRetry(
        stringResource(id = R.string.unable_to_get_shows_list)
    ) {}
}