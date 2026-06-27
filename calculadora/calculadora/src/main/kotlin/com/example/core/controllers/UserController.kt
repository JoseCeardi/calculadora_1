package com.example.core.controllers

import com.example.core.dtos.*
import com.example.core.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    /*
    ------------------- USER CRUD -------------------
     */

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserResponseDTO>> {
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userService.getUserById(id))
        } catch (e: Exception) {
            ResponseEntity.status(404).body(mapOf("error" to e.message))
        }
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody dto: UpdateUserRequestDTO
    ): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userService.updateUser(id, dto))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(mapOf("error" to e.message))
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            userService.deleteUser(id)
            ResponseEntity.ok(mapOf("message" to "Usuario desactivado correctamente"))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(mapOf("error" to e.message))
        }
    }

    /*
    ------------------- LOGIN / AUTH -------------------
     */

    @PostMapping("/register")
    fun register(@RequestBody dto: RegisterRequestDTO): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userService.registrarUsuario(dto))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(mapOf("error" to e.message))
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody dto: LoginRequestDTO): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userService.login(dto))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(mapOf("error" to e.message))
        }
    }
}