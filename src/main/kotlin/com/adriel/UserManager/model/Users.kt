package com.adriel.UserManager.model

import jakarta.persistence.*

@Entity
@Table(name = "users", schema = "public")
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = true)
    val email: String
)
