package com.belajar.foodmarket.data.remote.dto.auth.login

import com.belajar.foodmarket.data.remote.dto.auth.Meta
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val `data`: Data,
    val meta: Meta
)