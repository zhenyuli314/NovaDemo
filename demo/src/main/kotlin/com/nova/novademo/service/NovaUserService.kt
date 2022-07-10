package com.nova.novademo.service

import com.nova.novademo.codegen.tables.daos.NovaUserDao
import com.nova.novademo.codegen.tables.pojos.NovaUserPojo
import com.nova.novademo.codegen.tables.references.NOVA_USER
import com.nova.novademo.vo.PageResult
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Nova user service
 *
 * @property mapper
 * @constructor Create empty Nova user service
 */
@Service
@Transactional(rollbackFor = [Exception::class])
class NovaUserService(@Resource var mapper: NovaUserDao) : BaseServiceImp<NovaUserPojo, String>(mapper) {

    override fun get(id: String): NovaUserPojo? {
        val entity = super.get(id)
        return checkDeleted(entity)
    }

    override fun listAll(): List<NovaUserPojo> {
        val result = mutableListOf<NovaUserPojo>()
        super.listAll().forEach{
            checkDeleted(it)?.let { it1 -> result.add(it1) }
        }
        return result
    }

    override fun listByIds(ids: Collection<String>): List<NovaUserPojo> {
        return dsl.select()
            .from(NOVA_USER)
            .where(NOVA_USER.ID.`in`(ids), NOVA_USER.DELETED.eq("0"))
            .fetchInto(NovaUserPojo::class.java)
    }

    /**
     * Page
     *      total需要先行计算，否则为当前页的记录条数
     * @param page
     * @return
     */
    override fun page(page: PageResult<NovaUserPojo>): PageResult<NovaUserPojo> {
        val step = dsl.selectFrom(NOVA_USER)
            .where(NOVA_USER.DELETED.eq("0"))
        val total: Long = dsl.fetchCount(step).toLong()
        val list = step
            .orderBy(NOVA_USER.ID.desc())
            .limit(page.currentPage!!.minus(1), page.pageSize)
            .fetchInto(NovaUserPojo::class.java)
        page.apply {
            this.data = list
            this.total = total
        }
        return page
    }


    /**
     * Check deleted
     * 逻辑删除检测，1为删除，0为未删除
     * @param entity
     * @return
     */
    fun checkDeleted(entity: NovaUserPojo?): NovaUserPojo? {
        return if (entity == null || entity.deleted == "1") null else entity
    }
}