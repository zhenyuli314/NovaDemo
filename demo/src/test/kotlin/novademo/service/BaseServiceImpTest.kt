package com.nova.novademo.service

import com.nova.novademo.codegen.tables.pojos.NovaUserPojo
import com.nova.novademo.vo.PageResult
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

import javax.annotation.Resource

@SpringBootTest
class BaseServiceImpTest {
    @Resource
    lateinit var service: NovaUserService

    @Test
    fun get() {
        println(service.get("1"))
    }

    @Test
    fun listAll() {
        println(service.listAll())
    }

    @Test
    fun listByIds() {
        println(service.listByIds(listOf("1", "2")))
    }


    @Test
    fun page() {
        println(service.page(PageResult(null, 1, 1, null)))
    }

    @Test
    fun save() {
//        service.save(entity = NovaUserPojo("5", "Allen", "Allen@163.com", "广州"))
    }

    @Test
    fun testSave() {
        var list = ArrayList<NovaUserPojo>()
        list.add(NovaUserPojo("6", "AAA", "AAA@163.com", "contryA"))
        list.add(NovaUserPojo("7", "BBB", "BBB@163.com", "contryB"))
        list.add(NovaUserPojo("8", "CCC", "CCC@163.com", "contryC"))
//        service.save(list)
    }

    @Test
    fun update() {
        service.update(NovaUserPojo("5", "Allen", "Allen@163.com", "珠海"))
    }

    @Test
    fun testUpdate() {

    }

    @Test
    fun delete() {
        service.delete("8")
    }

    @Test
    fun testDelete() {
        service.delete(listOf("6", "7"))
    }
}