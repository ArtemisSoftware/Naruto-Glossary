package com.artemissoftware.narutoglossary.presentation.screens.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.artemissoftware.narutoglossary.domain.model.Hero
import com.artemissoftware.narutoglossary.ui.theme.SMALL_PADDING

@Composable
fun ListContent(
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {

    Log.d("LazyColumn", heroes.loadState.toString())

    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = heroes,
            key = { hero ->
                hero.id
            }
        ) { hero ->
            hero?.let {
                HeroItem(hero = it, navController = navController)
            }
        }
    }
}