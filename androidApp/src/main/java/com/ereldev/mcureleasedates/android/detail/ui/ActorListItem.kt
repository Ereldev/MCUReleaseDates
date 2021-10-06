package com.ereldev.mcureleasedates.android.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ereldev.mcureleasedates.android.common.ui.ShowImage
import com.ereldev.mcureleasedates.business.credits.factory.CreditsFactory
import com.ereldev.mcureleasedates.business.credits.model.Actor
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun ActorListItem(actor: Actor) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(77.dp)
            .fillMaxHeight(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Column {
            ShowImage(
                url = actor.profilePath,
                description = actor.name,
                modifier = Modifier
                    .width(77.dp)
                    .height(115.dp)
            )
            Text(
                text = actor.name,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = actor.character,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun ShimmerActorListItem(shimmerInstance: Shimmer? = null) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(77.dp)
            .fillMaxHeight()
            .shimmer(shimmerInstance),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(77.dp)
                    .height(115.dp)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth(0.8f)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth(0.6f)
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth(0.6f)
                    .background(Color.LightGray)
            )
        }
    }
}

@Preview
@Composable
fun ActorListItemPreview() {
    ActorListItem(CreditsFactory.fixedCredits().cast.first())
}

@Preview
@Composable
fun ShimmerActorListItemPreview() {
    ShimmerActorListItem()
}