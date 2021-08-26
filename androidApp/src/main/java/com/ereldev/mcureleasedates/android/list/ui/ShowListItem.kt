package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.mcureleasedates.business.show.model.Show

@Composable
fun ShowListItem(show: Show, onShowClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Text(text = show.title, modifier = Modifier.padding(8.dp))
    }
}

@Preview
@Composable
fun PreviewShowListItem() {
    ShowListItem(Show("Venom")) {}
}