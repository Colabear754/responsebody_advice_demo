package com.colabear754.responsebody_advice_demo.dto

import com.colabear754.responsebody_advice_demo.constants.ResponseCode

data class CommonResponse<T>(
    val code: ResponseCode,
    val data: T? = null
) {
    val message: String = code.message
}
