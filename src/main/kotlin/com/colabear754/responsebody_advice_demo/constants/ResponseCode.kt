package com.colabear754.responsebody_advice_demo.constants

enum class ResponseCode(
    val message: String
) {
    SUCCESS("성공"),
    ERROR01("사용자 정보를 찾을 수 없습니다."),
}
