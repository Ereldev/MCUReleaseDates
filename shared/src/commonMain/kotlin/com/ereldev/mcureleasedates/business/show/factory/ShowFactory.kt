package com.ereldev.mcureleasedates.business.show.factory

import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.ShowType
import com.ereldev.mcureleasedates.business.show.model.Shows

object ShowFactory {

    fun emptyShows() = Shows(listOf(), listOf())

    fun fixedShows() = Shows(
        listOf(
            Show(ShowType.MOVIE,1, "Spiderman 3", "overview", "2021-11-24", "2021-11-24", "${ShowApi.POSTER_URL}/xeItgLK9qcafxbd8kYgv7XnMEog.jpg"),
            Show(ShowType.MOVIE,2, "Venom 2", "overview", "2021-11-24", "2021-11-24")
        ),
        listOf(
            Show(ShowType.TV,3, "What If?", "overview", "2021-11-24", "2021-11-24")
        )
    )

}