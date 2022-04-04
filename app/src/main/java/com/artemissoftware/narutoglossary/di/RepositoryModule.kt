package com.artemissoftware.narutoglossary.di

import android.content.Context
import com.artemissoftware.narutoglossary.data.operations.DataStoreOperationsImpl
import com.artemissoftware.narutoglossary.data.repository.Repository
import com.artemissoftware.narutoglossary.domain.operations.DataStoreOperations
import com.artemissoftware.narutoglossary.domain.usecase.hero.GetAllHeroesUseCase
import com.artemissoftware.narutoglossary.domain.usecase.hero.HeroesUseCases
import com.artemissoftware.narutoglossary.domain.usecase.onboarding.GetOnBoardingCompletionUseCase
import com.artemissoftware.narutoglossary.domain.usecase.onboarding.OnboardingUseCases
import com.artemissoftware.narutoglossary.domain.usecase.onboarding.SaveOnBoardingCompletionUseCase
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
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideOnboardingUseCases(repository: Repository): OnboardingUseCases {
        return OnboardingUseCases(
            getOnBoardingCompletionUseCase = GetOnBoardingCompletionUseCase(repository = repository),
            saveOnBoardingCompletionUseCase = SaveOnBoardingCompletionUseCase(repository = repository)
        )
    }

    @Provides
    @Singleton
    fun provideHeroesUseCases(repository: Repository): HeroesUseCases {
        return HeroesUseCases(
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository)
        )
    }
}