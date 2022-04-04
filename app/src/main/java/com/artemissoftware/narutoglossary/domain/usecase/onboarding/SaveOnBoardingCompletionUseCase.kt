package com.artemissoftware.narutoglossary.domain.usecase.onboarding

import com.artemissoftware.narutoglossary.data.repository.Repository

class SaveOnBoardingCompletionUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}