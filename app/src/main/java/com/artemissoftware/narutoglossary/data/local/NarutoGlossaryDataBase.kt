package com.artemissoftware.narutoglossary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.artemissoftware.narutoglossary.data.local.dao.HeroDao
import com.artemissoftware.narutoglossary.data.local.dao.HeroRemoteKeysDao
import com.artemissoftware.narutoglossary.domain.model.Hero
import com.artemissoftware.narutoglossary.domain.model.HeroRemoteKeys

@Database(entities = [
        Hero::class,
        HeroRemoteKeys::class
    ],
    version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class NarutoGlossaryDataBase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao

}