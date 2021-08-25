package com.ereldev.mcureleasedates.android.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.ereldev.mcureleasedates.android.list.movies.MoviesScreen
import com.ereldev.mcureleasedates.android.list.tvshows.TVShowsScreen

@Composable
fun ListScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = ListTab.values().map { stringResource(it.titleId) }

    Column {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = (selectedTabIndex == index),
                    onClick = { selectedTabIndex = index }
                ) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(Dp(15f))
                    )
                }
            }
        }
        when(selectedTabIndex) {
            ListTab.Movies.ordinal -> { MoviesScreen() }
            ListTab.TVShows.ordinal -> { TVShowsScreen() }
        }
    }
}

@Preview
@Composable
fun PreviewListScreen() {
    ListScreen()
}