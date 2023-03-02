package com.example.pagingcomposehilt.components.activities.main

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingcomposehilt.components.activities.main.domain.GetRepoListUseCase
import com.example.pagingcomposehilt.components.activities.main.model.Repository
import javax.inject.Inject

class GithubSource @Inject constructor(
    private val getRepo: GetRepoListUseCase
) : PagingSource<Int, Repository>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
        return try {
            val nextPage = params.key ?: 1
            val repoListResponse = getRepo.execute(nextPage, 10)

            LoadResult.Page(
                data = repoListResponse,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Repository>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}