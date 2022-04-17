package com.artemissoftware.narutoglossary.domain.usecase.hero

import com.artemissoftware.narutoglossary.data.repository.Repository
import com.artemissoftware.narutoglossary.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}