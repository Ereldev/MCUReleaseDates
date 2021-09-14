package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ereldev.mcureleasedates.android.detail.ui.DETAIL_SCREEN_NAME
import com.ereldev.mcureleasedates.android.list.ListViewModel
import com.ereldev.mcureleasedates.business.show.model.Show

const val LIST_SCREEN_NAME = "list"

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    listViewModel: ListViewModel = viewModel(),
    navController: NavController
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val loading by remember { listViewModel.loading }

    Scaffold {
        if (loading) {
            ListLoading()
        } else {
            Column {
                when(selectedTabIndex) {
                    ListTab.Movies.ordinal -> { listViewModel.movies }
                    ListTab.TVShows.ordinal -> { listViewModel.tvShows }
                    else -> null
                }?.let {
                    ShowsList(
                        it,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) { show -> onShowClick(navController, show) }
                }

                Tabs(selectedTabIndex) {
                    selectedTabIndex = it
                }
            }
        }
    }
}

private fun onShowClick(navController: NavController, show: Show) {
    navController.navigate(DETAIL_SCREEN_NAME)
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
