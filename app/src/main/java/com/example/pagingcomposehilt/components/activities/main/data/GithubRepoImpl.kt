package com.example.pagingcomposehilt.components.activities.main.data

import com.example.pagingcomposehilt.components.activities.main.domain.GithubRepository
import com.example.pagingcomposehilt.components.activities.main.model.Repository

class GithubRepoImpl (private val service: GithubService): GithubRepository {
    override suspend fun getRepos(page: Int, perPage: Int): List<Repository> {
        return service.getRepos(page, perPage)
    }
}