package com.ereldev.mcureleasedates.android.common.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
}

@Preview
@Composable
fun Title1Preview() {
    Title1(text = "Title 1")
}

@Composable
fun Title2(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview
@Composable
fun Title2Preview() {
    Title2(text = "Title 2")
}