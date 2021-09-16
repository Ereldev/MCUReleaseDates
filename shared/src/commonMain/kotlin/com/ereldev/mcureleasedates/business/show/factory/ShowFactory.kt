package com.ereldev.mcureleasedates.business.show.factory

import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.Shows

object ShowFactory {

    fun emptyShows() = Shows(listOf(), listOf())

    fun fixedShows() = Shows(
        listOf(
            Show(1, "Spiderman 3", "overview", "2021-11-24"),
            Show(2, "Venom 2", "overview", "2021-11-24")
        ),
        listOf(
            Show(3, "What If?", "overview", "2021-11-24")
        )
    )

}