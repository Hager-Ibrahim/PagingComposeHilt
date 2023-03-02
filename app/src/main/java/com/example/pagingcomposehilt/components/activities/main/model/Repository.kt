package com.example.pagingcomposehilt.components.activities.main.model

import com.squareup.moshi.Json

data class Repository (
		@Json(name = "id")
		val id: Int,
		@Json(name = "url")
		var url: String,
		@Json(name = "repository_url")
		val repositoryUrl: String,
		@Json(name = "user")
		val user: User
)