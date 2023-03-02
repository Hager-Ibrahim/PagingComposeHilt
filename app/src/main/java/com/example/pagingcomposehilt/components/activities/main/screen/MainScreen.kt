package com.example.pagingcomposehilt.components.activities.main.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pagingcomposehilt.components.activities.main.GithubRepoViewModel
import com.example.pagingcomposehilt.components.activities.main.model.Repository
import kotlinx.coroutines.flow.Flow
import androidx.paging.compose.items
import androidx.work.ListenableWorker.Result.retry


@Composable
fun MainScreen(lazyMovieItems: LazyPagingItems<Repository>, onClick: (Int)-> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Repos") }
            )
        },
        content = {
            MovieList(lazyMovieItems, onClick)
        }
    )
}

@Composable
fun MovieList(lazyMovieItems: LazyPagingItems<Repository>, onClick: (Int)-> Unit) {

    LazyColumn {

        items(lazyMovieItems) { repo ->
            repo?.let {
                MovieItem(it, onClick)
            }
        }


        lazyMovieItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyMovieItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyMovieItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItem(repository: Repository, onClick: (Int)-> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight().clickable {
                onClick(repository.id)
            },
        elevation = 4.dp
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            text = repository.url,
            maxLines = 2,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis
        )
    }

}