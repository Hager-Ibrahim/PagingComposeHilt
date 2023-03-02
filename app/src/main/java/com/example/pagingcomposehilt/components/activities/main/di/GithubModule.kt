package com.example.pagingcomposehilt.components.activities.main.di

import com.example.pagingcomposehilt.components.activities.main.data.GithubRepoImpl
import com.example.pagingcomposehilt.components.activities.main.data.GithubService
import com.example.pagingcomposehilt.components.activities.main.domain.GetRepoListUseCase
import com.example.pagingcomposehilt.components.activities.main.domain.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class GithubModule {
    @ViewModelScoped
    @Provides
    fun provideStaffRetroFitService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

    @ViewModelScoped
    @Provides
    fun provideStaffUsersRepository(service: GithubService): GithubRepository =
        GithubRepoImpl(service)



}