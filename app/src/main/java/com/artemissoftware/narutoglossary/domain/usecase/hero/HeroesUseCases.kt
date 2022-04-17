package com.artemissoftware.narutoglossary.domain.usecase.hero

data class HeroesUseCases (
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)