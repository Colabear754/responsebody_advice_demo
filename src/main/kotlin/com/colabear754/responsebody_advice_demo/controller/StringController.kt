package com.colabear754.responsebody_advice_demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StringController {
    @GetMapping("/string")
    fun string(): String {
        return "Hello, World!"
    }
}