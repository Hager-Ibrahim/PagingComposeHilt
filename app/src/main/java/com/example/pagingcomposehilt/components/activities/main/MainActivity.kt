package com.example.pagingcomposehilt.components.activities.main

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pagingcomposehilt.components.activities.main.screen.MainScreen
import com.example.pagingcomposehilt.ui.theme.PagingComposeHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: GithubRepoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagingComposeHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var staffList =viewModel.repos.collectAsLazyPagingItems()
                    MainScreen(staffList){



                        Log.d("TAG", "onCreate: ${staffList.get(1)} ")
                        Log.d("TAG", "onCreate: ${staffList.itemSnapshotList} ")

                        //staffList.get(0)= staffList[index].copy(jobTitle = "Updated!")
                    }
                }
            }
        }
    }
}
