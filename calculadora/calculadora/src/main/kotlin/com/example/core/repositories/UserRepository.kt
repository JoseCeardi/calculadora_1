package com.example.core.repositories

import com.example.core.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
    fun findByEmail(email: String): UserEntity?
    fun existsByUsername(username: String): Boolean
}