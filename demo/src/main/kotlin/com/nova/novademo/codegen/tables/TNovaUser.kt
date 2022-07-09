/*
 * This file is generated by jOOQ.
 */
package com.nova.novademo.codegen.tables


import com.nova.novademo.codegen.keys.KEY_NOVA_USER_PRIMARY
import com.nova.novademo.codegen.tables.records.NovaUserRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row7
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * USER TABLE
 */
@Suppress("UNCHECKED_CAST")
open class TNovaUser(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, NovaUserRecord>?,
    aliased: Table<NovaUserRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<NovaUserRecord>(
    alias,
    com.nova.novademo.codegen.NovaDemo.`NOVA-DEMO`,
    child,
    path,
    aliased,
    parameters,
    DSL.comment("USER TABLE"),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>nova-demo.nova_user</code>
         */
        val NOVA_USER = TNovaUser()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<NovaUserRecord> = NovaUserRecord::class.java

    /**
     * The column <code>nova-demo.nova_user.id</code>. ID
     */
    val ID: TableField<NovaUserRecord, String?> = createField(DSL.name("id"), SQLDataType.VARCHAR(128).nullable(false), this, "ID")

    /**
     * The column <code>nova-demo.nova_user.username</code>.
     */
    val USERNAME: TableField<NovaUserRecord, String?> = createField(DSL.name("username"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>nova-demo.nova_user.email</code>.
     */
    val EMAIL: TableField<NovaUserRecord, String?> = createField(DSL.name("email"), SQLDataType.VARCHAR(50), this, "")

    /**
     * The column <code>nova-demo.nova_user.address</code>.
     */
    val ADDRESS: TableField<NovaUserRecord, String?> = createField(DSL.name("address"), SQLDataType.VARCHAR(128), this, "")

    /**
     * The column <code>nova-demo.nova_user.create_time</code>.
     */
    val CREATE_TIME: TableField<NovaUserRecord, LocalDateTime?> = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>nova-demo.nova_user.update_time</code>.
     */
    val UPDATE_TIME: TableField<NovaUserRecord, LocalDateTime?> = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>nova-demo.nova_user.deleted</code>.
     */
    val DELETED: TableField<NovaUserRecord, String?> = createField(DSL.name("deleted"), SQLDataType.VARCHAR(11).nullable(false).defaultValue(DSL.inline("0", SQLDataType.VARCHAR)), this, "")

    private constructor(alias: Name, aliased: Table<NovaUserRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<NovaUserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>nova-demo.nova_user</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>nova-demo.nova_user</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>nova-demo.nova_user</code> table reference
     */
    constructor(): this(DSL.name("nova_user"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, NovaUserRecord>): this(Internal.createPathAlias(child, key), child, key, NOVA_USER, null)
    override fun getSchema(): Schema = com.nova.novademo.codegen.NovaDemo.`NOVA-DEMO`
    override fun getPrimaryKey(): UniqueKey<NovaUserRecord> = KEY_NOVA_USER_PRIMARY
    override fun getKeys(): List<UniqueKey<NovaUserRecord>> = listOf(KEY_NOVA_USER_PRIMARY)
    override fun `as`(alias: String): TNovaUser = TNovaUser(DSL.name(alias), this)
    override fun `as`(alias: Name): TNovaUser = TNovaUser(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): TNovaUser = TNovaUser(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): TNovaUser = TNovaUser(name, null)

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row7<String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, String?> = super.fieldsRow() as Row7<String?, String?, String?, String?, LocalDateTime?, LocalDateTime?, String?>
}