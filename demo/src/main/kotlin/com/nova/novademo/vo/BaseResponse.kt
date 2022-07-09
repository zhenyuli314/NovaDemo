package com.nova.novademo.vo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.Accessors


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
open class BaseResponse(_resultCode: ResultCode){
    var code:Int = _resultCode.code
    var msg:String = _resultCode.msg
}
