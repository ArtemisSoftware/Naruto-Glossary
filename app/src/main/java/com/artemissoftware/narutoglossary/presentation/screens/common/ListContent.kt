package com.artemissoftware.narutoglossary.presentation.screens.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.artemissoftware.narutoglossary.domain.model.Hero

@Composable
fun ListContent(
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {

}