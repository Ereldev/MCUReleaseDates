package com.ereldev.mcureleasedates.business.show

import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.Shows

class GetShowsUseCase {

    suspend fun execute() = Shows(
        listOf(Show("Spiderman 3"), Show("Venom 2")),
        listOf(Show("What If?"))
    )

}