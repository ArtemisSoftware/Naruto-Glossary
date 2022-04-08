package com.artemissoftware.narutoglossary.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.artemissoftware.narutoglossary.domain.model.Hero
import com.artemissoftware.narutoglossary.domain.usecase.hero.HeroesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val heroesUseCases: HeroesUseCases
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedHeroes = MutableStateFlow<PagingData<Hero>>(PagingData.empty())
    val searchedHeroes = _searchedHeroes

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    @InternalCoroutinesApi
    fun searchHeroes(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            heroesUseCases.searchHeroesUseCase(query = query).cachedIn(viewModelScope).collect {
                _searchedHeroes.value = it
            }
        }
    }
}