package com.colabear754.responsebody_advice_demo.controller

import com.colabear754.responsebody_advice_demo.entity.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping("/user")
    fun user(): User {
        return User(id = 1L, name = "콜라곰", phone = "010-1234-5678", email = "colabear754@demo.com")
    }
}