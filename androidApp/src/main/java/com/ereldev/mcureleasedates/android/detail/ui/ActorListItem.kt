package com.ereldev.mcureleasedates.android.detail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ereldev.mcureleasedates.android.common.ui.ShowImage
import com.ereldev.mcureleasedates.business.credits.factory.CreditsFactory
import com.ereldev.mcureleasedates.business.credits.model.Actor

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

@Preview
@Composable
fun ActorListItemPreview() {
    ActorListItem(CreditsFactory.fixedCredits().cast.first())
}