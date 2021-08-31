package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ereldev.mcureleasedates.android.R
import com.ereldev.mcureleasedates.business.show.factory.ShowFactory
import com.ereldev.mcureleasedates.business.show.model.Show

@ExperimentalMaterialApi
@Composable
fun ShowsList(shows: List<Show>, modifier: Modifier = Modifier, onShowClick: (Show) -> Unit) {
    val listState = rememberLazyListState()

    if (shows.isEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = stringResource(id = R.string.nothing_to_see_for_now),
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    } else {
        LazyColumn(state = listState, modifier = modifier) {
            items(shows) { show ->
                ShowListItem(show) { onShowClick(show) }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun PreviewShowsList() {
    ShowsList(ShowFactory.fixedShows().movies) {}
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun PreviewEmptyShowsList() {
    ShowsList(ShowFactory.emptyShows().movies) {}
}