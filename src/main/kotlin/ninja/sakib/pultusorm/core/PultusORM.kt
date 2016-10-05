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

    fun save(value: Any) {
        if (isValidObject(value)) {
            PultusORMQuery(connection!!).save(value)
        } else {
            throwback("${value.javaClass.simpleName} must extend model class")
        }
    }

    fun save(value: Any, callback: Callback) {
        if (isValidObject(value)) {
            PultusORMQuery(connection!!).save(value, callback)
        } else {
            throwback("${value.javaClass.simpleName} must extend model class")
        }
    }

    fun update(value: Any, updater: PultusORMUpdater) {
        PultusORMQuery(connection!!).update(value, updater)
    }

    fun update(value: Any, callback: Callback) {

    }

    fun get(value: Any): MutableList<Any> {
        return PultusORMQuery(connection!!).get(value)
    }

    fun get(value: Any, condition: PultusORMCondition): MutableList<Any> {
        return PultusORMQuery(connection!!).get(value, condition)
    }

    fun delete(value: Any) {
        PultusORMQuery(connection!!).delete(value)
    }

    fun delete(value: Any, condition: PultusORMCondition) {
        PultusORMQuery(connection!!).delete(value, condition)
    }

    fun delete(value: Any, callback: Callback) {
        PultusORMQuery(connection!!).delete(value, callback)
    }

    fun delete(value: Any, condition: PultusORMCondition, callback: Callback) {
        PultusORMQuery(connection!!).delete(value, condition, callback)
    }
}
