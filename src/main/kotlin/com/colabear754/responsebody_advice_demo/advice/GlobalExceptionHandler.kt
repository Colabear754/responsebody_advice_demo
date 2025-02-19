package com.colabear754.responsebody_advice_demo.advice

import com.colabear754.responsebody_advice_demo.constants.ResponseCode
import com.colabear754.responsebody_advice_demo.dto.CommonResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(): ResponseEntity<CommonResponse<*>> {
        return ResponseEntity.badRequest().body(CommonResponse(ResponseCode.ERROR01, null))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(): ResponseEntity<CommonResponse<*>> {
        return ResponseEntity.internalServerError().body(CommonResponse(ResponseCode.ERROR99, null))
    }
}