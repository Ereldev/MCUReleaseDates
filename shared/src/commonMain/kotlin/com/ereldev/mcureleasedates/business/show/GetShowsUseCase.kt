package com.ereldev.mcureleasedates.business.show

import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.Shows
import com.ereldev.mcureleasedates.business.show.repository.ShowRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class GetShowsUseCase(
    private val showRepository: ShowRepository
) {

    suspend fun execute(): Shows {
        return coroutineScope {
            // Run all api calls in //
            val mcuMoviesAsync = async { showRepository.getMovies(ShowApi.KEYWORD_MCU) }
            val marvelComicsMoviesAsync = async { showRepository.getMovies(ShowApi.KEYWORD_MARVEL_COMICS) }
            val mcuTVShowsAsync = async { showRepository.getTVShows(ShowApi.KEYWORD_MCU) }
            val marvelComicsTVShowsAsync = async { showRepository.getTVShows(ShowApi.KEYWORD_MARVEL_COMICS) }

            // Wait for api calls to be done
            val mcuMovies = mcuMoviesAsync.await()
            val marvelComicsMovies = marvelComicsMoviesAsync.await()
            val mcuTVShows = mcuTVShowsAsync.await()
            val marvelComicsTVShows = marvelComicsTVShowsAsync.await()

            // Merge shows
            val movies = mcuMovies
                .union(marvelComicsMovies)
                .sortedBy { it.originalDate }

            val tvShows = mcuTVShows
                .union(marvelComicsTVShows)
                .sortedBy { it.originalDate }

            Shows(
                movies,
                tvShows
            )
        }
    }

}