package com.colabear754.responsebody_advice_demo.constants

enum class ResponseCode(
    val message: String
) {
    SUCCESS("성공"),
    ERROR01("잘못된 요청"),
    ERROR99("알 수 없는 오류")
}
