package com.belajar.foodmarket.data.remote.dto.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val access_token: String,
    val token_type: String,
    val user: User
)