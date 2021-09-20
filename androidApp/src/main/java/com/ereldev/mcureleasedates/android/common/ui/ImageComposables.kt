package com.ereldev.mcureleasedates.android.common.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.mcureleasedates.android.R
import com.ereldev.mcureleasedates.business.show.factory.ShowFactory
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ShowImage(url: String?, description: String?, modifier: Modifier = Modifier) {
    CoilImage(
        imageModel = url ?: painterResource(R.drawable.movie_placeholder),
        placeHolder = painterResource(R.drawable.movie_placeholder),
        error = painterResource(R.drawable.movie_placeholder),
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun PosterImage(url: String?, description: String?, modifier: Modifier = Modifier) {
    ShowImage(
        url = url,
        description = description,
        modifier = modifier
            .shadow(2.dp, shape = RoundedCornerShape(corner = CornerSize(5.dp)))
    )
}

@Preview
@Composable
fun PosterImagePreview() {
    ShowFactory.fixedShows().movies.first().let {
        PosterImage(
            url = it.image,
            description = it.title,
            modifier = Modifier
                .width(77.dp)
                .height(115.dp)
        )
    }
}

@Preview
@Composable
fun PosterImagePlaceHolderPreview() {
    ShowFactory.fixedShows().movies.first().let {
        PosterImage(
            url = null,
            description = null,
            modifier = Modifier
                .width(77.dp)
                .height(115.dp)
        )
    }
}