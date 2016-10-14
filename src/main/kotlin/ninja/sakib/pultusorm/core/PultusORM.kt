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


/**
 * Base class of PultusORM API
 * It handles database connection
 * and serves queries
 */
class PultusORM {
    private var databaseName: String? = null    // Name of the database
    private var databasePath: String? = null    // Path to database
    private var connection: Connection? = null  // Connection to database

    /**
     * Constructor to initialize class with database name
     * In this case user home path will be used as database path
     * @param databaseName Name of the database to connect
     */
    constructor(databaseName: String) {
        this.databaseName = databaseName

        connect()
    }

    /**
     * Constructor to initialize class with database name & database path
     * @param databaseName Name of the database to connect
     * @param databasePath Path to database
     */
    constructor(databaseName: String, databasePath: String) {
        this.databaseName = databaseName
        this.databasePath = databasePath

        connect()
    }

    /**
     * Method to initialize connection to database
     */
    private fun connect() {
        Class.forName("org.sqlite.JDBC")

        if (databaseName!!.endsWith(".db").not())
            databaseName = "$databaseName.db"

        if (databasePath == null || databasePath!!.isEmpty())
            databasePath = getUserHomeDirectory()

        connection = DriverManager.getConnection("jdbc:sqlite:$databasePath/$databaseName")
    }

    /**
     * Method to save data
     * @param clazz Class object which data want to add
     */
    fun save(clazz: Any) {
        PultusORMQuery(connection!!).save(clazz)
    }

    /**
     * Method to save data with callback
     * @param clazz Class object which data want to add
     * @param callback will be fired on task complete
     */
    fun save(clazz: Any, callback: Callback) {
        PultusORMQuery(connection!!).save(clazz, callback)
    }

    /**
     * Method to update value
     * @param clazz value of which class going to update
     * @param updater holds update condition and values
     */
    fun update(clazz: Any, updater: PultusORMUpdater) {
        PultusORMQuery(connection!!).update(clazz, updater)
    }

    /**
     * Method to update value with callback async
     * @param clazz value of which class going to update
     * @param updater holds update condition and values
     * @param callback will be fired on task complete
     */
    fun update(clazz: Any, updater: PultusORMUpdater, callback: Callback) {
        PultusORMQuery(connection!!).update(clazz, updater, callback)
    }

    /**
     * Method to get data of specific clazz
     * It's deprecated use find method instead
     * @param clazz which class of data will provide
     * @return MutableList of type Any
     */
    @Deprecated("use find instead of get")
    fun get(clazz: Any): MutableList<Any> {
        return PultusORMQuery(connection!!).get(clazz)
    }

    /**
     * Method to get data of specific clazz
     * @param clazz which class of data will provide
     * @return MutableList of type Any
     */
    fun find(clazz: Any): MutableList<Any> {
        return PultusORMQuery(connection!!).get(clazz)
    }

    /**
     * Method to get data of specific clazz based of provided condition
     * It's deprecated use find method instead
     * @param clazz which class of data will provide
     * @param condition condition will be used to get data
     * @return MutableList of type Any
     */
    @Deprecated("use find instead of get")
    fun get(clazz: Any, condition: PultusORMCondition): MutableList<Any> {
        return PultusORMQuery(connection!!).get(clazz, condition)
    }

    /**
     * Method to get data of specific clazz based of provided condition
     * @param clazz which class of data will provide
     * @param condition condition will be used to get data
     * @return MutableList of type Any
     */
    fun find(clazz: Any, condition: PultusORMCondition): MutableList<Any> {
        return PultusORMQuery(connection!!).get(clazz, condition)
    }

    /**
     * Method to delete data of specific clazz
     * @param clazz which type of data will be deleted
     */
    fun delete(clazz: Any) {
        PultusORMQuery(connection!!).delete(clazz)
    }

    /**
     * Method to delete data of specific clazz based on condition
     * @param clazz which type of data will be deleted
     * @param condition will be used to delete data
     */
    fun delete(clazz: Any, condition: PultusORMCondition) {
        PultusORMQuery(connection!!).delete(clazz, condition)
    }

    /**
     * Method to delete data of specific clazz with callback
     * @param clazz which type of data will be deleted
     * @param callback will be fired on task complete
     */
    fun delete(clazz: Any, callback: Callback) {
        PultusORMQuery(connection!!).delete(clazz, callback)
    }

    /**
     * Method to delete data of specific clazz based on condition with callback
     * @param clazz which type of data will be deleted
     * @param condition will be used to delete data
     * @param callback will be fired on task complete
     */
    fun delete(clazz: Any, condition: PultusORMCondition, callback: Callback) {
        PultusORMQuery(connection!!).delete(clazz, condition, callback)
    }

    /**
     * Method to drop table
     * @param clazz which type of table will be deleted
     */
    fun drop(clazz: Any) {
        PultusORMQuery(connection!!).drop(clazz)
    }

    /**
     * Method to drop table with callback
     * @param clazz which type of table will be deleted
     * @param callback will be fired on task complete
     */
    fun drop(clazz: Any, callback: Callback) {
        PultusORMQuery(connection!!).drop(clazz, callback)
    }

    /**
     * Method to get number of objects of a specific type
     * @param clazz which type of data will count
     */
    fun count(clazz: Any): Long {
        return PultusORMQuery(connection!!).count(clazz)
    }
}
