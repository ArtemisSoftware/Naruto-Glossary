package com.artemissoftware.narutoglossary.domain.usecase.hero

import androidx.paging.PagingData
import com.artemissoftware.narutoglossary.data.repository.Repository
import com.artemissoftware.narutoglossary.domain.model.Hero
import kotlinx.coroutines.flow.Flow


class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}