package com.artemissoftware.narutoglossary.di

import android.content.Context
import com.artemissoftware.narutoglossary.data.repository.DataStoreRepositoryImpl
import com.artemissoftware.narutoglossary.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository {
        return DataStoreRepositoryImpl(context = context)
    }

//    @Provides
//    @Singleton
//    fun provideUseCases(repository: Repository): UseCases {
//        return UseCases(
//            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
//            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
//        )
//    }

}