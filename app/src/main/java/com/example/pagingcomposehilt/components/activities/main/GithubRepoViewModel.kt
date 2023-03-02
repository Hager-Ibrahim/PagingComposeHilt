package com.example.pagingcomposehilt.components.activities.main

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.map
import com.example.pagingcomposehilt.components.activities.main.data.GithubService
import com.example.pagingcomposehilt.components.activities.main.model.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubRepoViewModel @Inject constructor(
    private val githubSource: GithubSource
): ViewModel()  {

    var repos= Pager(PagingConfig(pageSize = 10)) {
        githubSource
    }.flow



}