package com.example.pagingcomposehilt.components.activities.main.model

import com.squareup.moshi.Json

data class User (
		@Json(name = "login")
		val login: String,
		@Json(name = "id")
		val id: Int,
		@Json(name = "avatar_url")
		val avatarUrl: String
)