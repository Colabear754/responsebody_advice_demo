package com.colabear754.responsebody_advice_demo.advice

import com.colabear754.responsebody_advice_demo.constants.ResponseCode
import com.colabear754.responsebody_advice_demo.dto.CommonResponse
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice(basePackages = ["com.colabear754.responsebody_advice_demo.controller"])
class CommonResponseAdvice : ResponseBodyAdvice<Any?> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return !converterType.isAssignableFrom(StringHttpMessageConverter::class.java)
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        return if (body?.javaClass != CommonResponse::class.java) {
            CommonResponse(ResponseCode.SUCCESS, body)
        } else {
            body
        }
    }
}