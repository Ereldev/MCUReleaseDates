package com.ereldev.mcureleasedates.android.detail.ui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.mcureleasedates.business.credits.factory.CreditsFactory
import com.ereldev.mcureleasedates.business.credits.model.Actor
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer

@Composable
fun CastList(cast: List<Actor>? = null, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)

    LazyRow(state = listState, modifier = modifier) {
        if (cast != null) {
            items(cast) { actor ->
                ActorListItem(actor)
            }
        } else {
            items(5) {
                ShimmerActorListItem(shimmerInstance)
            }
        }
    }
}

@Preview
@Composable
fun CastListPreview() {
    CastList(CreditsFactory.fixedCredits().cast)
}