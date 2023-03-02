package com.example.pagingcomposehilt.components.activities.main.domain

import com.example.pagingcomposehilt.components.activities.main.model.Repository

interface GithubRepository {
    suspend fun getRepos(
        page: Int, perPage: Int): List<Repository>
}