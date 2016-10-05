package ninja.sakib.pultusorm.core

import ninja.sakib.pultusorm.callbacks.Callback
import java.sql.Connection
import java.sql.DriverManager

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORM {
    private var databaseName: String? = null
    private var databasePath: String? = null
    private var connection: Connection? = null

    constructor(databaseName: String) {
        this.databaseName = databaseName

        connect()
    }

    constructor(databaseName: String, databasePath: String) {
        this.databaseName = databaseName
        this.databasePath = databasePath

        connect()
    }

    private fun connect() {
        Class.forName("org.sqlite.JDBC")

        if (databaseName!!.endsWith(".db").not())
            databaseName = "$databaseName.db"

        if (databasePath == null || databasePath!!.isEmpty())
            databasePath = getUserHomeDirectory()

        connection = DriverManager.getConnection("jdbc:sqlite:$databasePath/$databaseName")
    }

    fun save(clazz: Any) {
        PultusORMQuery(connection!!).save(clazz)
    }

    fun save(clazz: Any, callback: Callback) {
        PultusORMQuery(connection!!).save(clazz, callback)
    }

    fun update(clazz: Any, updater: PultusORMUpdater) {
        PultusORMQuery(connection!!).update(clazz, updater)
    }

    fun update(clazz: Any, updater: PultusORMUpdater, callback: Callback) {
        PultusORMQuery(connection!!).update(clazz, updater, callback)
    }

    fun get(clazz: Any): MutableList<Any> {
        return PultusORMQuery(connection!!).get(clazz)
    }

    fun get(clazz: Any, condition: PultusORMCondition): MutableList<Any> {
        return PultusORMQuery(connection!!).get(clazz, condition)
    }

    fun delete(clazz: Any) {
        PultusORMQuery(connection!!).delete(clazz)
    }

    fun delete(clazz: Any, condition: PultusORMCondition) {
        PultusORMQuery(connection!!).delete(clazz, condition)
    }

    fun delete(clazz: Any, callback: Callback) {
        PultusORMQuery(connection!!).delete(clazz, callback)
    }

    fun delete(clazz: Any, condition: PultusORMCondition, callback: Callback) {
        PultusORMQuery(connection!!).delete(clazz, condition, callback)
    }

    fun drop(clazz: Any) {
        PultusORMQuery(connection!!).drop(clazz)
    }

    fun drop(clazz: Any, callback: Callback) {
        PultusORMQuery(connection!!).drop(clazz, callback)
    }
}
