package com.example.pagingcomposehilt.components.activities.main.data

import com.example.pagingcomposehilt.components.activities.main.model.Repository
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("issues")
    suspend fun getRepos(
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
        ): List<Repository>
}