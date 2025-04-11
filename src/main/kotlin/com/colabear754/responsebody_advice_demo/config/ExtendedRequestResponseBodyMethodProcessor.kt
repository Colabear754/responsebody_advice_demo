package com.colabear754.responsebody_advice_demo.config

import com.colabear754.responsebody_advice_demo.constants.ResponseCode
import com.colabear754.responsebody_advice_demo.dto.CommonResponse
import org.springframework.core.MethodParameter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor

class ExtendedRequestResponseBodyMethodProcessor(
    converters: List<HttpMessageConverter<*>>
) : RequestResponseBodyMethodProcessor(converters) {
    override fun handleReturnValue(
        returnValue: Any?,
        returnType: MethodParameter,
        mavContainer: ModelAndViewContainer,
        webRequest: NativeWebRequest
    ) {
        super.handleReturnValue(
            returnValue.let { if (it is String?) CommonResponse(ResponseCode.SUCCESS, it) else it },
            returnType,
            mavContainer,
            webRequest
        )
    }
}