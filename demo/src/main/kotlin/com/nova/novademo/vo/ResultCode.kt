package com.nova.novademo.vo

enum class ResultCode(val code : Int,val msg:String) {
    OK(6000,"处理完成"),
    FAIL(7000,"业务内部异常"),
    ILLEGAL_PARAMS(7001,"参数错误"),
    ACCESS_KEY_NOT_EFFECT(8001,"请求令牌无效"),
    USER_DISABLED(9001,"用户无效"),
    NOT_LOGIN(9002,"未登录")
}