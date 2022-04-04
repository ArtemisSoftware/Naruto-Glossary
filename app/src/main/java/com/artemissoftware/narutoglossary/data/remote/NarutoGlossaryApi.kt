package com.artemissoftware.narutoglossary.data.remote

import com.artemissoftware.narutoglossary.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NarutoGlossaryApi {

    @GET("/characters/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/characters/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}