package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.mcureleasedates.android.list.ListViewModel
import com.ereldev.mcureleasedates.business.show.model.Show

@Composable
fun ListScreen(listViewModel: ListViewModel = viewModel()) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val loading by remember { listViewModel.loading }

    Scaffold {
        if (loading) {
            Text(text = "Loading ...")
        } else {
            Column {
                Tabs(selectedTabIndex) { selectedTabIndex = it }

                when(selectedTabIndex) {
                    ListTab.Movies.ordinal -> {
                        ShowsList(listViewModel.movies) { onShowClick(it) }
                    }
                    ListTab.TVShows.ordinal -> {
                        ShowsList(listViewModel.tvShows) { onShowClick(it) }
                    }
                }
            }
        }
    }
}

private fun onShowClick(show: Show) {

}

@Composable
fun Tabs(selectedTabIndex: Int, onTabChange: (Int) -> Unit) {
    val tabTitles = ListTab.values().map { stringResource(it.titleId) }

    TabRow(selectedTabIndex = selectedTabIndex) {
        tabTitles.forEachIndexed { index, title ->
            Tab(
                selected = (selectedTabIndex == index),
                onClick = { onTabChange(index) }
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListScreen() {
    ListScreen()
}