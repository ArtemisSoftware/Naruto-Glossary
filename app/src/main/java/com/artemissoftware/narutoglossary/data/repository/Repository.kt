package com.artemissoftware.narutoglossary.data.repository

import com.artemissoftware.narutoglossary.domain.operations.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun getOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}