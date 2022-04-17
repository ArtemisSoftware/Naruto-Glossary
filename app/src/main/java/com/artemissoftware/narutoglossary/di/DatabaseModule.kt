package com.artemissoftware.narutoglossary.di

import android.content.Context
import androidx.room.Room
import com.artemissoftware.narutoglossary.data.local.NarutoGlossaryDataBase
import com.artemissoftware.narutoglossary.data.repository.LocalDataSourceImpl
import com.artemissoftware.narutoglossary.domain.repository.LocalDataSource
import com.artemissoftware.narutoglossary.util.Constants.NARUTO_GLOSSARY_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NarutoGlossaryDataBase::class.java,
        NARUTO_GLOSSARY_DATABASE
    ).build()



    @Provides
    @Singleton
    fun provideLocalDataSource(
        narutoGlossaryDataBase: NarutoGlossaryDataBase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            narutoGlossaryDataBase = narutoGlossaryDataBase
        )
    }
}