package com.artemissoftware.narutoglossary.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.artemissoftware.narutoglossary.data.local.NarutoGlossaryDataBase
import com.artemissoftware.narutoglossary.data.pagingsource.HeroRemoteMediator
import com.artemissoftware.narutoglossary.data.pagingsource.SearchHeroesSource
import com.artemissoftware.narutoglossary.data.remote.NarutoGlossaryApi
import com.artemissoftware.narutoglossary.domain.model.Hero
import com.artemissoftware.narutoglossary.domain.repository.RemoteDataSource
import com.artemissoftware.narutoglossary.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl (
    private val narutoGlossaryApi: NarutoGlossaryApi,
    private val narutoGlossaryDataBase: NarutoGlossaryDataBase
) : RemoteDataSource {

    private val heroDao = narutoGlossaryDataBase.heroDao()


    override fun getAllHeroes(): Flow<PagingData<Hero>> {

        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                narutoGlossaryApi = narutoGlossaryApi,
                narutoGlossaryDataBase = narutoGlossaryDataBase
            ),
            pagingSourceFactory = { heroDao.getAllHeroes() }
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {

        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(narutoGlossaryApi = narutoGlossaryApi, query = query)
            }
        ).flow
    }
}