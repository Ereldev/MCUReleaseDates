package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.mcureleasedates.business.show.model.Show

@Composable
fun ShowsList(shows: List<Show>, onShowClick: (Show) -> Unit) {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        items(shows) { show ->
            ShowListItem(show) { onShowClick(show) }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMoviesScreen() {
    ShowsList(listOf(Show("Spiderman 3", "overview"), Show("Venom 2", "overview"))) {}
}