package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ereldev.mcureleasedates.android.R
import com.ereldev.mcureleasedates.business.show.model.Show

@Composable
fun ShowListItem(show: Show, onShowClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(R.drawable.movie_placeholder),
                contentDescription = "",
                Modifier
                    .width(75.dp)
                    .shadow(2.dp, shape = RoundedCornerShape(corner = CornerSize(5.dp)))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = show.title, maxLines = 1, style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Bold
                ))
                Text(text = show.overview, maxLines = 3, fontSize = 14.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewShowListItem() {
    ShowListItem(Show("Venom 2", "Let There Be Carnage ...")) {}
}