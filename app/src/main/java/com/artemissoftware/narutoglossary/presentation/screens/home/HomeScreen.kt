package com.artemissoftware.narutoglossary.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.artemissoftware.narutoglossary.presentation.screens.home.composables.HomeTopBar
import androidx.paging.compose.collectAsLazyPagingItems
import com.artemissoftware.narutoglossary.navigation.Screen
import com.artemissoftware.narutoglossary.presentation.screens.common.ListContent

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {
                navController.navigate(Screen.Search.route)
            })
        },
        content = {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}