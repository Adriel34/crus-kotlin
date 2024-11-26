package com.adriel.UserManager.service

import com.adriel.UserManager.model.Users
import com.adriel.UserManager.repository.UserRepository
import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll(): List<Users> = userRepository.findAll()

    fun findById(id: Long): Users = userRepository.findById(id).orElseThrow {
        NoSuchElementException("User not found with id: $id")
    }

    fun save(user: Users): Users = userRepository.save(user)

    fun update(id: Long, updatedUser: Users): Users {
        val existingUser = findById(id)
        return userRepository.save(existingUser.copy(name = updatedUser.name, email = updatedUser.email))
    }

    fun delete(id: Long) {
        val user = findById(id)
        userRepository.delete(user)
    }
}
