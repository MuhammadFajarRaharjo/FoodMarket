package com.belajar.foodmarket.data.remote.dto.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val address: String,
    val city: String,
    val created_at: String,
    val current_team_id: Int?,
    val email: String,
    val email_verified_at: Boolean?,
    val houseNumber: String,
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val picturePath: String?,
    val profile_photo_url: String,
    val roles: String,
    val updated_at: String
)