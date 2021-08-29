package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.mcureleasedates.business.show.model.Show

@ExperimentalMaterialApi
@Composable
fun ShowsList(shows: List<Show>, modifier: Modifier = Modifier, onShowClick: (Show) -> Unit) {
    val listState = rememberLazyListState()

    LazyColumn(state = listState, modifier = modifier) {
        items(shows) { show ->
            ShowListItem(show) { onShowClick(show) }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun PreviewMoviesScreen() {
    ShowsList(
        listOf(
            Show("Spiderman 3", "overview", "2021-11-24"),
            Show("Venom 2", "overview", "2021-11-24")
        )
    ) {}
}