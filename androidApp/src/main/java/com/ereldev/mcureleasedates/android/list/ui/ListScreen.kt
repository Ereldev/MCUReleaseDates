package com.ereldev.mcureleasedates.android.list.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.mcureleasedates.android.list.ListViewModel
import com.ereldev.mcureleasedates.business.show.model.Show

@ExperimentalMaterialApi
@Composable
fun ListScreen(listViewModel: ListViewModel = viewModel()) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val loading by remember { listViewModel.loading }
    val c = LocalContext.current

    Scaffold {
        if (loading) {
            Text(text = "Loading ...")
        } else {
            Column {
                when(selectedTabIndex) {
                    ListTab.Movies.ordinal -> { listViewModel.movies }
                    ListTab.TVShows.ordinal -> { listViewModel.tvShows }
                    else -> null
                }?.let {
                    ShowsList(it, modifier = Modifier.weight(1f)) { show -> onShowClick(c, show) }
                }

                Tabs(selectedTabIndex) {
                    selectedTabIndex = it
                }
            }
        }
    }
}

private fun onShowClick(context: Context, show: Show) {
    Toast.makeText(context, show.title, Toast.LENGTH_LONG).show()
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

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun PreviewListScreen() {
    ListScreen()
}