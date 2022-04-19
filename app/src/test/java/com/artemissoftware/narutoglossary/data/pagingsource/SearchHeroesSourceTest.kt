package com.artemissoftware.narutoglossary.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingSource.*
import com.artemissoftware.narutoglossary.data.remote.FakeNarutoGlossaryApi
import com.artemissoftware.narutoglossary.data.remote.NarutoGlossaryApi
import com.artemissoftware.narutoglossary.domain.model.Hero
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SearchHeroesSourceTest {

    private lateinit var narutoGlossaryApi: NarutoGlossaryApi
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        narutoGlossaryApi = FakeNarutoGlossaryApi()

        heroes = listOf(
            Hero(
                id = 1,
                name = "Sasuke",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            Hero(
                id = 2,
                name = "Naruto",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            Hero(
                id = 3,
                name = "Sakura",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            )
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Search api with existing hero name, expect single hero result, assert LoadResult_Page`() =
        runBlockingTest {

            val heroSource = SearchHeroesSource(narutoGlossaryApi = narutoGlossaryApi, query = "Sasuke")

            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with existing hero name, expect multiple hero result, assert LoadResult_Page`() =
        runBlockingTest {

            val heroSource = SearchHeroesSource(narutoGlossaryApi = narutoGlossaryApi, query = "Sa")

            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first(), heroes[2]),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() =
        runBlockingTest {

            val heroSource = SearchHeroesSource(narutoGlossaryApi = narutoGlossaryApi, query = "")

            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = narutoGlossaryApi.searchHeroes("").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runBlockingTest {

            val heroSource = SearchHeroesSource(narutoGlossaryApi = narutoGlossaryApi, query = "Unknown")

            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = narutoGlossaryApi.searchHeroes("Unknown").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

}

