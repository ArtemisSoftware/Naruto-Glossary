package com.artemissoftware.narutoglossary.domain.repository

import com.artemissoftware.narutoglossary.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}