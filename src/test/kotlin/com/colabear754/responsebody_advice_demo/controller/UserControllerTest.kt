package com.colabear754.responsebody_advice_demo.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(UserController::class)
class UserControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {
    @Test
    fun `ResponseAdvice 동작 테스트`() {
        mockMvc.get("/user")
            .andExpect {
                status { isOk() }
                jsonPath("$.code") { value("SUCCESS") }
                jsonPath("$.message") { value("성공") }
                jsonPath("$.data") { isMap() }
                jsonPath("$.data.id") { value(1L) }
                jsonPath("$.data.name") { value("콜라곰") }
                jsonPath("$.data.phone") { value("010-1234-5678") }
                jsonPath("$.data.email") { value("colabear754@demo.com") }
            }
    }
}