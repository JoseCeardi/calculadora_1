package com.example.core.dtos

data class RegisterRequestDTO(
    val username: String,
    val email: String,
    val passwordRaw: String
)

data class LoginRequestDTO(
    val email: String,
    val passwordRaw: String
)

data class UpdateUserRequestDTO(
    val username: String? = null,
    val email: String? = null
)

// DTOs de respuesta con el campo 'activo' agregado
data class AuthResponseDTO(
    val id: Long,
    val username: String,
    val email: String,
    val token: String,
    val activo: Boolean
)

data class UserResponseDTO(
    val id: Long,
    val username: String,
    val email: String,
    val activo: Boolean
)