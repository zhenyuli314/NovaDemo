package com.nova.novademo.controller


import com.nova.novademo.codegen.tables.pojos.NovaUserPojo
import com.nova.novademo.service.NovaUserService
import com.nova.novademo.vo.BaseResponse
import com.nova.novademo.vo.ObjectResultResponse
import com.nova.novademo.vo.ResultCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.swing.text.html.parser.Entity

@RestController
@RequestMapping("user")
class NovaUserController : BaseController<NovaUserService, NovaUserPojo>() {
    override fun preSave(entity: NovaUserPojo):NovaUserPojo{
        super.preSave(entity)
        checkNotNull(entity.address) { "地址信息不能为空" }
        checkNotNull(entity.email) { "email不能为空" }
        checkNotNull(entity.username) { "用户姓名不能为空" }
        return entity
    }

    override fun preUpdate(entity: NovaUserPojo): NovaUserPojo {
        super.preUpdate(entity)
        checkNotNull(entity.address) { "地址信息不能为空" }
        checkNotNull(entity.email) { "email不能为空" }
        checkNotNull(entity.username) { "用户姓名不能为空" }
        return entity
    }

    override fun prePage(params: Map<String, Any>): Map<String, Any> {
        return super.prePage(params)
    }

    override fun preDelete(id: String): String {
        return super.preDelete(id)
    }
}