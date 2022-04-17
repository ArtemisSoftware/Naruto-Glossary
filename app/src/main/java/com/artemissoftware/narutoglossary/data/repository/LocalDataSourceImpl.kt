package com.artemissoftware.narutoglossary.data.repository

import com.artemissoftware.narutoglossary.data.local.NarutoGlossaryDataBase
import com.artemissoftware.narutoglossary.domain.model.Hero
import com.artemissoftware.narutoglossary.domain.repository.LocalDataSource

class LocalDataSourceImpl(narutoGlossaryDataBase: NarutoGlossaryDataBase): LocalDataSource {

    private val heroDao = narutoGlossaryDataBase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}