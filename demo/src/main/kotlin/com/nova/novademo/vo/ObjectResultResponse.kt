package com.nova.novademo.vo

class ObjectResultResponse<T>(
    resultCode: ResultCode,
    var records: T?
) : BaseResponse(
    resultCode
) {
    /**
     * 请求成功
     */
    constructor(records: T) : this(ResultCode.OK,records)

}