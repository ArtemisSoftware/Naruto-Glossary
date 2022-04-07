package com.artemissoftware.narutoglossary.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.artemissoftware.narutoglossary.presentation.screens.common.ListContent
import com.artemissoftware.narutoglossary.presentation.screens.search.composables.SearchTopBar

@Composable
fun SearchScreen() {

//    val searchQuery by searchViewModel.searchQuery
//    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
//            SearchTopBar(
//                text = searchQuery,
//                onTextChange = {
//                    searchViewModel.updateSearchQuery(query = it)
//                },
//                onSearchClicked = {
//                    searchViewModel.searchHeroes(query = it)
//                },
//                onCloseClicked = {
//                    navController.popBackStack()
//                }
//            )
        },
        content = {
//            ListContent(heroes = heroes, navController = navController)
        }
    )
}