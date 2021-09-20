package com.ereldev.mcureleasedates.android.detail.ui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.mcureleasedates.business.credits.factory.CreditsFactory
import com.ereldev.mcureleasedates.business.credits.model.Actor

@Composable
fun CastList(cast: List<Actor>, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()

    LazyRow(state = listState, modifier = modifier) {
        items(cast) { actor ->
            ActorListItem(actor)
        }
    }
}

@Preview
@Composable
fun CastListPreview() {
    CastList(CreditsFactory.fixedCredits().cast)
}