package com.nova.novademo.service

import com.nova.novademo.vo.PageResult

/**
 * 通用 Service 接口
 *
 * @param <P> POJO
 * @param <T> 主键类型
 */
interface BaseService<P, T> {
    /**
     * 通过主键获取数据
     *
     * @param id 主键
     * @return 实体对象
     */
    fun get(id: T): P?

    /**
     * 获取全部数据
     *
     * @return 实体集合
     */
    fun listAll(): List<P>

    /**
     * 通过主键获取批量数据
     *
     * @param ids 主键集合
     * @return 实体集合
     */
    fun listByIds(ids: Collection<T>): List<P>

    /**
     * 获取分页数据
     *
     * @param page 分页对象
     * @return 分页数据包装
     */
    fun page(page: PageResult<P>): PageResult<P>

    /**
     * 插入数据（字段值为空忽略）, 如果主键是自动生成的，会返回
     *
     * @param entity 实体对象
     * @return
     */
    fun save(entity: P)

    /**
     * 批量插入数据（字段值为空忽略）
     *
     * @param entities 实体对象集合
     * @return
     */
    fun save(entities: Collection<P>)

    /**
     * 根据主键更新数据（默认不更新参数为空的字段）
     *
     * @param entity 实体对象
     * @return
     */
    fun update(entity: P)

    /**
     * 根据主键批量更新
     *
     * @param entities 实体对象集合
     * @return
     */
    fun update(entities: Collection<P>)

    /**
     * 根据主键删除数据
     *
     * @param id 主键
     * @return
     */
    fun delete(id: T)

    /**
     * 根据主键批量删除数据
     *
     * @param ids 主键集合
     * @return
     */
    fun delete(ids: Collection<T>)
}