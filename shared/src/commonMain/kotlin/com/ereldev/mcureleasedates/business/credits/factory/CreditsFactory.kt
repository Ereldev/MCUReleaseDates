package com.ereldev.mcureleasedates.business.credits.factory

import com.ereldev.mcureleasedates.business.credits.model.Actor
import com.ereldev.mcureleasedates.business.credits.model.Credits

object CreditsFactory {

    fun fixedCredits() = Credits(
        listOf(
            Actor("Tom Holand", "Peter Parker", null),
            Actor("Chris Evens", "Steve Rogers", null)
        )
    )

}