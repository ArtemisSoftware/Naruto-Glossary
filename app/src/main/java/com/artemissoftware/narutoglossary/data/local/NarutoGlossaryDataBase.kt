package com.artemissoftware.narutoglossary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.artemissoftware.narutoglossary.data.local.dao.HeroDao
import com.artemissoftware.narutoglossary.domain.model.Hero

@Database(entities = [
        Hero::class,
    ],
    version = 1)
abstract class NarutoGlossaryDataBase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

}