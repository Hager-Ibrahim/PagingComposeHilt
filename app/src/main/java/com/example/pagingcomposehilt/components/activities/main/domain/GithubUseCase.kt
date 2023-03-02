package com.example.pagingcomposehilt.components.activities.main.domain

import com.example.pagingcomposehilt.components.activities.main.model.Repository
import javax.inject.Inject

class GetRepoListUseCase @Inject constructor(private val repo: GithubRepository): BaseUseCase {
    suspend fun execute(page: Int, perPage: Int): List<Repository> {
        return repo.getRepos(page, perPage)
    }
}