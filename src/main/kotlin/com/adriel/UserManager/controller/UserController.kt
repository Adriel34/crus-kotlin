package com.adriel.UserManager.controller

import com.adriel.UserManager.model.Users
import com.adriel.UserManager.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<Users>> = ResponseEntity.ok(userService.findAll())

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<Users> = ResponseEntity.ok(userService.findById(id))

    @PostMapping
    fun createUser(@RequestBody user: Users): ResponseEntity<Users> = ResponseEntity.ok(userService.save(user))

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: Users): ResponseEntity<Users> =
        ResponseEntity.ok(userService.update(id, user))

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
