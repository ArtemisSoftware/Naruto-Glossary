package com.artemissoftware.narutoglossary.di

import androidx.paging.ExperimentalPagingApi
import com.artemissoftware.narutoglossary.data.local.NarutoGlossaryDataBase
import com.artemissoftware.narutoglossary.data.remote.NarutoGlossaryApi
import com.artemissoftware.narutoglossary.data.repository.RemoteDataSourceImpl
import com.artemissoftware.narutoglossary.domain.repository.RemoteDataSource
import com.artemissoftware.narutoglossary.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideNarutoGlossaryApi(retrofit: Retrofit): NarutoGlossaryApi {
        return retrofit.create(NarutoGlossaryApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(
        narutoGlossaryApi: NarutoGlossaryApi,
        narutoGlossaryDataBase: NarutoGlossaryDataBase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            narutoGlossaryApi = narutoGlossaryApi,
            narutoGlossaryDataBase = narutoGlossaryDataBase
        )
    }
}