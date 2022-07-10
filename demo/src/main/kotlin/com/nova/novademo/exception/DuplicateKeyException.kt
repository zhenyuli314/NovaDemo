package com.nova.novademo.exception

import com.nova.novademo.vo.ResultCode

class DuplicateKeyException(msg: String) : BaseException(msg = msg, status = ResultCode.ILLEGAL_PARAMS.code)