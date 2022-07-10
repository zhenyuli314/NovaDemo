package com.nova.novademo.vo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.Accessors


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
open class BaseResponse(
    var code: Int,
    var msg: String? = null
) {
    constructor(resultCode: ResultCode) : this(resultCode.code, resultCode.msg)
}
