package com.artemissoftware.narutoglossary.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SearchViewModel /*@Inject*/ constructor(
    //private val useCases: UseCases
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}