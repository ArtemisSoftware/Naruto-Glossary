package com.artemissoftware.narutoglossary.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.artemissoftware.narutoglossary.data.remote.NarutoGlossaryApi
import com.artemissoftware.narutoglossary.domain.model.Hero
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val narutoGlossaryApi: NarutoGlossaryApi,
    private val query: String
) : PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = narutoGlossaryApi.searchHeroes(name = query)
            val heroes = apiResponse.heroes
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}