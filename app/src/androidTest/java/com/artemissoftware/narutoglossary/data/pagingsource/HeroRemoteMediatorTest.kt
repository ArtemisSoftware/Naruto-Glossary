package com.artemissoftware.narutoglossary.data.pagingsource

import androidx.paging.*
import androidx.paging.RemoteMediator.*
import androidx.test.core.app.ApplicationProvider
import com.artemissoftware.narutoglossary.data.local.NarutoGlossaryDataBase
import com.artemissoftware.narutoglossary.data.remote.FakeNarutoGlossaryApi2
import com.artemissoftware.narutoglossary.domain.model.Hero
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class HeroRemoteMediatorTest  {

    private lateinit var narutoGlossaryApi: FakeNarutoGlossaryApi2
    private lateinit var narutoGlossaryDataBase: NarutoGlossaryDataBase

    @Before
    fun setup() {
        narutoGlossaryApi = FakeNarutoGlossaryApi2()
        narutoGlossaryDataBase = NarutoGlossaryDataBase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanup() {
        narutoGlossaryDataBase.clearAllTables()
    }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadReturnsSuccessResultWhenMoreDataIsPresent() =
        runBlocking {
            val remoteMediator = HeroRemoteMediator(
                narutoGlossaryApi = narutoGlossaryApi,
                narutoGlossaryDataBase = narutoGlossaryDataBase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Success)
            assertFalse((result as MediatorResult.Success).endOfPaginationReached)
        }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadSuccessAndEndOfPaginationTrueWhenNoMoreData() =
        runBlocking {

            narutoGlossaryApi.clearData()

            val remoteMediator = HeroRemoteMediator(
                narutoGlossaryApi = narutoGlossaryApi,
                narutoGlossaryDataBase = narutoGlossaryDataBase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Success)
            assertTrue((result as MediatorResult.Success).endOfPaginationReached)
        }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() =
        runBlocking {

            narutoGlossaryApi.addException()

            val remoteMediator = HeroRemoteMediator(
                narutoGlossaryApi = narutoGlossaryApi,
                narutoGlossaryDataBase = narutoGlossaryDataBase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )

            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Error)
        }

}
