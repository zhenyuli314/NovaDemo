/*
 * This file is generated by jOOQ.
 */
package com.nova.novademo.codegen.tables.pojos


import com.nova.novademo.codegen.tables.interfaces.INovaUser

import java.time.LocalDateTime


/**
 * USER TABLE
 */
@Suppress("UNCHECKED_CAST")
data class NovaUserPojo(
    override var id: String? = null, 
    override var username: String? = null, 
    override var email: String? = null, 
    override var address: String? = null, 
    override var createTime: LocalDateTime? = null, 
    override var updateTime: LocalDateTime? = null, 
    override var deleted: String? = null
): INovaUser {


    override fun toString(): String {
        val sb = StringBuilder("NovaUserPojo (")

        sb.append(id)
        sb.append(", ").append(username)
        sb.append(", ").append(email)
        sb.append(", ").append(address)
        sb.append(", ").append(createTime)
        sb.append(", ").append(updateTime)
        sb.append(", ").append(deleted)

        sb.append(")")
        return sb.toString()
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    override fun from(from: INovaUser) {
        id = from.id
        username = from.username
        email = from.email
        address = from.address
        createTime = from.createTime
        updateTime = from.updateTime
        deleted = from.deleted
    }

    override fun <E : INovaUser> into(into: E): E {
        into.from(this)
        return into
    }
}