package com.artemissoftware.narutoglossary.domain.usecase.onboarding

import com.artemissoftware.narutoglossary.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetOnBoardingCompletionUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.getOnBoardingState()
    }
}