package com.nova.novademo.vo

class ObjectResultResponse<T>(
    resultCode: ResultCode,
    var records: T? = null
) : BaseResponse(
    resultCode = resultCode
) {
    /**
     * 请求成功
     */
    constructor(records: T) : this(ResultCode.OK, records)

}