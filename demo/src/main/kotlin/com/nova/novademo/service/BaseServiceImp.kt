package com.nova.novademo.service

import com.nova.novademo.codegen.NovaDemo
import com.nova.novademo.utli.DateTimeUtil
import com.nova.novademo.vo.PageResult
import org.jooq.DSLContext
import org.jooq.impl.DAOImpl
import javax.annotation.Resource

/**
 * 抽象通用Service
 * @param <P>
 * @param <T>
 */
const val CREATE_TIME = "createTime"
const val UPDATE_TIME = "updateTime"
const val DELETED = "deleted"

abstract class BaseServiceImp<P, T,>(_dao: DAOImpl<*, P, T>) : BaseService<P, T> {
    @Resource
    lateinit var dsl: DSLContext

    var dao: DAOImpl<*, P, T> = _dao

    override fun get(id: T): P? {
        return dao.findById(id)
    }

    override fun listAll(): List<P> {
        return dao.findAll()
    }

    abstract override fun listByIds(ids: Collection<T>): List<P>

    abstract override fun page(page: PageResult<P>): PageResult<P>

    override fun save(entity: P) {
        fillCreateOrUpdateTime(entity, CREATE_TIME)
        dao.insert(entity)
    }

    fun fillCreateOrUpdateTime(entity: P, name: String) {
        val javaEntity = entity!!::class.java
        when (name) {
            CREATE_TIME -> {
                val createTimeField = javaEntity.getDeclaredField(CREATE_TIME)
                createTimeField.isAccessible = true
                createTimeField.set(entity, DateTimeUtil.curremtTime())
            }
            else -> {
                val updateTimeField = javaEntity.getDeclaredField(UPDATE_TIME)
                updateTimeField.isAccessible = true
                updateTimeField.set(entity, DateTimeUtil.curremtTime())
            }
        }
    }

    override fun save(entities: Collection<P>) {
        entities.forEach {
            fillCreateOrUpdateTime(it, CREATE_TIME)
        }
        dao.insert(entities)
    }

    override fun update(entity: P) {
        fillCreateOrUpdateTime(entity, UPDATE_TIME)
        dao.update(entity)
    }

    override fun update(entities: Collection<P>) {
        entities.forEach {
            fillCreateOrUpdateTime(it, UPDATE_TIME)
        }
        dao.update(entities)
    }

    override fun delete(id: T) {
        val entity = dao.findById(id)
        val javaEntity = entity!!::class.java
        val deleted = javaEntity.getDeclaredField(DELETED)
        deleted.isAccessible = true
        deleted.set(entity, "1")
        dao.update(entity)
    }

    override fun delete(ids: Collection<T>) {
        ids.forEach {
            delete(it)
        }
    }
}