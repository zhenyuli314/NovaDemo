package com.nova.novademo.exception

import com.nova.novademo.vo.ResultCode

open class BaseException(msg: String, val status: Int = ResultCode.FAIL.code) : RuntimeException(msg)