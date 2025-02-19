package com.colabear754.responsebody_advice_demo.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
class ExceptionControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {
    @Test
    fun `예외 발생 시 ResponseAdvice 동작 테스트`() {
        mockMvc.get("/error01")
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.code") { value("ERROR01") }
                jsonPath("$.message") { value("잘못된 요청") }
                jsonPath("$.data") { doesNotExist() }
            }
    }
}