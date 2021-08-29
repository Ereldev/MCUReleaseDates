package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ereldev.mcureleasedates.android.R
import com.ereldev.mcureleasedates.business.show.model.Show
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterialApi
@Composable
fun ShowListItem(show: Show, onShowClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = { onShowClick() }
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            GlideImage(
                imageModel = show.image ?: painterResource(R.drawable.movie_placeholder),
                placeHolder = painterResource(R.drawable.movie_placeholder),
                error = painterResource(R.drawable.movie_placeholder),
                contentDescription = show.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(77.dp)
                    .height(115.dp)
                    .shadow(2.dp, shape = RoundedCornerShape(corner = CornerSize(5.dp)))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = show.title, maxLines = 1, style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Bold
                ))
                Text(text = show.title, color = Color.LightGray, fontSize = 14.sp)
                Text(text = show.overview, maxLines = 4, fontSize = 14.sp)
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewShowListItem() {
    ShowListItem(Show("Venom 2", "Let There Be Carnage ...")) {}
}