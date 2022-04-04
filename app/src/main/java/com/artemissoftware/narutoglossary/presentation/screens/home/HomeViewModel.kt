package com.artemissoftware.narutoglossary.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.artemissoftware.narutoglossary.domain.usecase.hero.GetAllHeroesUseCase
import com.artemissoftware.narutoglossary.domain.usecase.hero.HeroesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    heroesUseCases: HeroesUseCases
): ViewModel() {
    val getAllHeroes = heroesUseCases.getAllHeroesUseCase()
}