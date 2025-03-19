package com.example.suhareva_up.Data.Models

import kotlinx.serialization.Serializable
import java.sql.Timestamp


@Serializable
data class Profile (
    val created_at: String?,
    val user_id: String?,
    val photo: String?,
    val firstname: String?,
    val lastname: String?,
    val address: String?,
    val phone: String?
)