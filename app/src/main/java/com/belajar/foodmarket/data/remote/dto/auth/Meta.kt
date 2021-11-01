package com.belajar.foodmarket.data.remote.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    val code: Int,
    val message: String,
    val status: String
)