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
            val spiderverseMoviesAsync = async { showRepository.getMovies(ShowApi.KEYWORD_SPIDERVERSE) }

            val mcuTVShowsAsync = async { showRepository.getTVShows(ShowApi.KEYWORD_MCU) }
            val marvelComicsTVShowsAsync = async { showRepository.getTVShows(ShowApi.KEYWORD_MARVEL_COMICS) }
            val spiderverseTVShowsAsync = async { showRepository.getTVShows(ShowApi.KEYWORD_SPIDERVERSE) }

            // Wait for api calls to be done
            val mcuMovies = mcuMoviesAsync.await()
            val marvelComicsMovies = marvelComicsMoviesAsync.await()
            val spiderverseMovies = spiderverseMoviesAsync.await()

            val mcuTVShows = mcuTVShowsAsync.await()
            val marvelComicsTVShows = marvelComicsTVShowsAsync.await()
            val spiderverseTVShows = spiderverseTVShowsAsync.await()

            // Merge shows
            val movies = mcuMovies
                .union(marvelComicsMovies)
                .union(spiderverseMovies)
                .sortedBy { it.originalDate }

            val tvShows = mcuTVShows
                .union(marvelComicsTVShows)
                .union(spiderverseTVShows)
                .sortedBy { it.originalDate }

            Shows(
                movies,
                tvShows
            )
        }
    }

}