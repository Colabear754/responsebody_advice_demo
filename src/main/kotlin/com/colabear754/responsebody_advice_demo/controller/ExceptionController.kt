package com.colabear754.responsebody_advice_demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExceptionController {
    @GetMapping("/error01")
    fun error() {
        throw IllegalArgumentException()
    }
}