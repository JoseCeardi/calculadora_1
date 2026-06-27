package com.example.core.services

import com.example.core.dtos.*
import com.example.core.entities.UserEntity
import com.example.core.repositories.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<UserResponseDTO> {
        return userRepository.findAll().map { user ->
            UserResponseDTO(
                id = user.id!!,
                username = user.username,
                email = user.email,
                activo = user.activo
            )
        }
    }

    fun getUserById(id: Long): UserResponseDTO {
        val user = userRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Usuario con ID $id no encontrado")

        return UserResponseDTO(
            id = user.id!!,
            username = user.username,
            email = user.email,
            activo = user.activo
        )
    }

    fun updateUser(id: Long, dto: UpdateUserRequestDTO): UserResponseDTO {
        val usuario = userRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Usuario con ID $id no encontrado")

        if (dto.username != null && dto.username != usuario.username) {
            if (userRepository.existsByUsername(dto.username)) {
                throw IllegalArgumentException("El nombre de usuario ya está en uso")
            }
            usuario.username = dto.username
        }

        if (dto.email != null && dto.email != usuario.email) {
            if (userRepository.findByEmail(dto.email) != null) {
                throw IllegalArgumentException("El email ya está registrado")
            }
            usuario.email = dto.email
        }

        val updatedUser = userRepository.save(usuario)

        return UserResponseDTO(
            id = updatedUser.id!!,
            username = updatedUser.username,
            email = updatedUser.email,
            activo = updatedUser.activo
        )
    }

    fun deleteUser(id: Long) {
        val usuario = userRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Usuario con ID $id no encontrado")

        usuario.activo = false
        userRepository.save(usuario)
    }

    fun registrarUsuario(dto: RegisterRequestDTO): AuthResponseDTO {
        if (userRepository.existsByUsername(dto.username)) {
            throw IllegalArgumentException("El nombre de usuario ya está en uso")
        }
        if (userRepository.findByEmail(dto.email) != null) {
            throw IllegalArgumentException("El email ya está registrado")
        }

        val nuevoUsuario = UserEntity(
            username = dto.username,
            email = dto.email,
            passwordHash = dto.passwordRaw
        )

        val savedUser = userRepository.save(nuevoUsuario)

        return AuthResponseDTO(
            id = savedUser.id!!,
            username = savedUser.username,
            email = savedUser.email,
            token = "token-jwt-simulado",
            activo = savedUser.activo
        )
    }

    fun login(dto: LoginRequestDTO): AuthResponseDTO {
        val usuario = userRepository.findByEmail(dto.email)
            ?: throw IllegalArgumentException("Usuario no encontrado")

        if (usuario.passwordHash != dto.passwordRaw) {
            throw IllegalArgumentException("Contraseña incorrecta")
        }

        return AuthResponseDTO(
            id = usuario.id!!,
            username = usuario.username,
            email = usuario.email,
            token = "token-jwt-simulado",
            activo = usuario.activo
        )
    }
}