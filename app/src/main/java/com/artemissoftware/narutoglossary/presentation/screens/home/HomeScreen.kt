package com.artemissoftware.narutoglossary.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.artemissoftware.narutoglossary.presentation.screens.home.composables.HomeTopBar

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
//            ListContent(
//                heroes = allHeroes,
//                navController = navController
//            )
        }
    )
}