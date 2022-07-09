package com.nova.novademo.vo


/**
 * Page result
 *
 * @param T
 * @property data 记录
 * @property pageSize 每页记录数量
 * @property currentPage 当前页码
 * @property total 记录总数
 * @constructor Create empty Page result
 */
data class PageResult<T>(
    var data: List<T>?,
    var pageSize: Int?,
    var currentPage: Int?,
    var total: Long?
)