package com.nova.novademo.handler

import com.nova.novademo.exception.DuplicateKeyException
import com.nova.novademo.vo.BaseResponse
import com.nova.novademo.vo.ResultCode
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

/**
 * Global exception handler
 *  全局异常处理
 * @constructor Create empty Global exception handler
 */
@RestControllerAdvice
class GlobalExceptionHandler {
    /**
     * Handle exception
     * 处理save时主键重复
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(DuplicateKeyException::class)
    fun handleException(request: HttpServletRequest, exception: DuplicateKeyException): BaseResponse {
        return BaseResponse(exception.status, exception.message)
    }

    /**
     * Handle exception
     *  处理所有异常
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception::class)
    fun handleException(request: HttpServletRequest, exception: Exception): BaseResponse {
        return BaseResponse(ResultCode.FAIL)
    }
}