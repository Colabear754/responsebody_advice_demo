package com.colabear754.responsebody_advice_demo.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
class StringControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {
    @Test
    fun `문자열 반환 테스트`() {
        mockMvc.get("/string")
            .andExpect {
                status { isOk() }
                jsonPath("$.code") { value("SUCCESS") }
                jsonPath("$.message") { value("성공") }
                jsonPath("$.data") { value("Hello, World!") }
            }
    }
}