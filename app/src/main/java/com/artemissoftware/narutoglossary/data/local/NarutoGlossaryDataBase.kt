package com.artemissoftware.narutoglossary.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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


    /**
     * For tests
     */
    companion object {
        fun create(context: Context, useInMemory: Boolean): NarutoGlossaryDataBase {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, NarutoGlossaryDataBase::class.java)
            } else {
                Room.databaseBuilder(context, NarutoGlossaryDataBase::class.java, "test_database.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}