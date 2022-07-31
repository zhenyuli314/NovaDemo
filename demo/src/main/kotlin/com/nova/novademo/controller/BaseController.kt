package com.nova.novademo.controller

import com.nova.novademo.service.BaseService

import com.nova.novademo.vo.BaseResponse
import com.nova.novademo.vo.ObjectResultResponse
import com.nova.novademo.vo.PageResult
import com.nova.novademo.vo.ResultCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import javax.annotation.Resource

/**
 * Base controller
 *
 * preXXX用于参数检查校验等，需子类重写
 * @param S service类型
 * @param P pojo类型
 * @constructor Create empty Base controller
 */
abstract class BaseController<S : BaseService<P, String>, P> {
    @Resource
    lateinit var service: S


    open fun preSave(entity: P): P {
        checkNotNull(entity)
        return entity
    }

    open fun preUpdate(entity: P): P {
        checkNotNull(entity)
        return entity
    }


    open fun prePage(params: Map<String, Any>): Map<String, Any> {
        checkNotNull(params)
        return params
    }

    open fun preDelete(id: String): String {
        checkNotNull(id)
        return id
    }

    @GetMapping("/getById")
    fun getById(id: String): BaseResponse {
        val entity = service.get(id)
        return ObjectResultResponse(entity)
    }

    @GetMapping("/getAll")
    fun getAll(): BaseResponse {
        val list = service.listAll()
        return ObjectResultResponse(list);
    }

    @GetMapping("/page")
    fun page(@RequestParam(required = false) params: Map<String, Any>): BaseResponse {
        this.prePage(params)
        val currentPage = params["currentPage"]?.let { it.toString().toInt() } ?: 1
        val pageSize = params["pageSize"]?.let { it.toString().toInt() } ?: 10
        val pageResult = service.page(PageResult(null, pageSize, currentPage, null))
        return ObjectResultResponse(pageResult)
    }


    @PostMapping("/save")
    fun save(@RequestBody entity: P): BaseResponse {
        service.save(this.preSave(entity))
        return ObjectResultResponse(ResultCode.OK.code)
    }

    @PostMapping("/update")
    fun update(@RequestBody entity: P): BaseResponse {
        service.update(this.preUpdate(entity))
        return ObjectResultResponse(ResultCode.OK.code)
    }

    @GetMapping("/delete")
    fun delete(id: String): BaseResponse {
        service.delete(id)
        return ObjectResultResponse(ResultCode.OK.code)
    }
}