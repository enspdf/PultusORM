package ninja.sakib.pultusorm.core

import com.eclipsesource.json.JsonObject
import ninja.sakib.pultusorm.callbacks.Callback
import ninja.sakib.pultusorm.exceptions.PultusORMException
import ninja.sakib.pultusorm.system.SqliteSystem
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import kotlin.properties.Delegates

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMQuery(connection: Connection) {
    enum class Type {
        SAVE,
        UPDATE,
        DELETE
    }

    enum class Sort {
        ASCENDING,
        DESCENDING
    }

    private var statement: Statement by Delegates.notNull<Statement>()

    init {
        this.statement = connection.createStatement()
    }

    fun save(value: Any) {
        try {
            createTable(value)

            statement.execute(Builder().insert(value))
            log(this.javaClass.simpleName, "Inserted into ${value.javaClass.simpleName} - Succeed")
        } catch (exception: Exception) {
            log(this.javaClass.simpleName, "Inserted into ${value.javaClass.simpleName} - Failed <${exception.message}>")
        }
    }

    fun save(value: Any, callback: Callback) {
        kotlin.run {
            try {
                createTable(value)

                statement.execute(Builder().insert(value))
                callback.onSuccess(Type.SAVE)
            } catch (exception: Exception) {
                val ormException: PultusORMException = PultusORMException(exception.message!!)
                callback.onFailure(Type.SAVE, ormException)
            }
        }
    }

    fun get(value: Any, condition: PultusORMCondition): MutableList<Any> {
        if (isTableExists(value.javaClass.simpleName).not())
            createTable(value)

        val resultList: MutableList<Any> = mutableListOf()
        val query = Builder().select(value, condition)
        try {
            val result: ResultSet = statement.executeQuery(query)

            while (result.next()) {
                val it: JsonObject = JsonObject()

                for (field in value.javaClass.declaredFields) {
                    if (isString(field.genericType)) {
                        it.add(field.name, result.getString(field.name))
                    } else if (isInt(field.genericType)) {
                        it.add(field.name, result.getInt(field.name))
                    } else if (isDouble(field.genericType)) {
                        it.add(field.name, result.getDouble(field.name))
                    } else if (isFloat(field.genericType)) {
                        it.add(field.name, result.getFloat(field.name))
                    } else if (isLong(field.genericType)) {
                        it.add(field.name, result.getLong(field.name))
                    } else if (isChar(field.genericType)) {
                        it.add(field.name, result.getString(field.name))
                    } else if (isBoolean(field.genericType)) {
                        val temp = result.getInt(field.name)
                        if (temp == 0)
                            it.add(field.name, false)
                        else it.add(field.name, true)
                    } else {
                        throwback("Unsupported data type.")
                    }
                }
                resultList.add(jsonAsObject(value, it))
            }
        } catch (exception: Exception) {
            throwback("Malformed query <${query.toString()}>.")
        }
        return resultList
    }

    fun get(value: Any): MutableList<Any> {
        if (isTableExists(value.javaClass.simpleName).not())
            createTable(value)

        val result: ResultSet = statement.executeQuery(Builder().select(value))
        val resultList: MutableList<Any> = mutableListOf()

        while (result.next()) {
            val it: JsonObject = JsonObject()

            for (field in value.javaClass.declaredFields) {
                if (isString(field.genericType)) {
                    it.add(field.name, result.getString(field.name))
                } else if (isInt(field.genericType)) {
                    it.add(field.name, result.getInt(field.name))
                } else if (isDouble(field.genericType)) {
                    it.add(field.name, result.getDouble(field.name))
                } else if (isFloat(field.genericType)) {
                    it.add(field.name, result.getFloat(field.name))
                } else if (isLong(field.genericType)) {
                    it.add(field.name, result.getLong(field.name))
                } else if (isChar(field.genericType)) {
                    it.add(field.name, result.getString(field.name))
                } else if (isBoolean(field.genericType)) {
                    val temp = result.getInt(field.name)
                    if (temp == 0)
                        it.add(field.name, false)
                    else it.add(field.name, true)
                } else {
                    throwback("Unsupported data type.")
                }
            }
            resultList.add(jsonAsObject(value, it))
        }
        return resultList
    }

    fun update(value: Any, updateQuery: PultusORMUpdater) {
        if (isTableExists(value.javaClass.simpleName).not())
            createTable(value)

        try {
            statement.execute(Builder().update(value, updateQuery))
        } catch (exception: Exception) {
            throwback("Malformed update query.")
        }
    }

    fun update(value: Any, updateQuery: PultusORMUpdater, callback: Callback) {
        kotlin.run {
            if (isTableExists(value.javaClass.simpleName).not())
                createTable(value)

            try {
                statement.execute(Builder().update(value, updateQuery))
                callback.onSuccess(Type.UPDATE)
            } catch (exception: Exception) {
                val ormException: PultusORMException = PultusORMException(exception.message!!)
                callback.onFailure(Type.UPDATE, ormException)
            }
        }
    }

    fun delete(value: Any) {
        try {
            statement.execute(Builder().delete(value))
            log(this.javaClass.simpleName, "Table ${parseClassName(value)} dropped - Succeed")
        } catch (exception: Exception) {
            log(this.javaClass.simpleName, "Table ${parseClassName(value)} dropped - Failed <${exception.message}>")
        }
    }

    fun delete(value: Any, condition: PultusORMCondition) {
        try {
            statement.execute(Builder().delete(value, condition))
            log(this.javaClass.simpleName, "Table ${parseClassName(value)} dropped - Succeed")
        } catch (exception: Exception) {
            log(this.javaClass.simpleName, "Table ${parseClassName(value)} dropped - Failed <${exception.message}>")
        }
    }

    fun delete(value: Any, callback: Callback) {
        kotlin.run {
            try {
                statement.execute(Builder().delete(value))
                callback.onSuccess(Type.DELETE)
            } catch (exception: Exception) {
                val ormException: PultusORMException = PultusORMException(exception.message!!)
                callback.onFailure(Type.DELETE, ormException)
            }
        }
    }

    fun delete(value: Any, condition: PultusORMCondition, callback: Callback) {
        kotlin.run {
            try {
                statement.execute(Builder().delete(value, condition))
                callback.onSuccess(Type.DELETE)
            } catch (exception: Exception) {
                val ormException: PultusORMException = PultusORMException(exception.message!!)
                callback.onFailure(Type.DELETE, ormException)
            }
        }
    }

    fun drop(value: Any) {

    }

    private fun isTableExists(tableName: String): Boolean {
        var result = statement.executeQuery("SELECT * FROM ${SqliteSystem.getTableName()}" +
                " WHERE type='${SqliteSystem.Type.TABLE.name.toLowerCase()}' AND name='$tableName';")
        var isExist = result.next()

        if (isExist)
            log(this.javaClass.simpleName, "table $tableName already exists.")
        else log(this.javaClass.simpleName, "table $tableName not exists")

        result.close()
        return isExist
    }

    private fun createTable(value: Any) {
        statement.execute(Builder().create(value))
        log(this.javaClass.simpleName, "table ${value.javaClass.simpleName} has been created.")
    }

    inner class Builder {
        fun create(value: Any): String {
            if (value.javaClass.declaredFields.size == 0)
                throwback("Class without field is not allowed.")

            val queryBuilder = StringBuilder()
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ${value.javaClass.simpleName}(")

            var isFirst = true
            for (field in value.javaClass.declaredFields) {
                if (isFirst.not())
                    queryBuilder.append(", ")

                val fieldPart: String = "${field.name} ${typeToSQL(field.genericType)} ${isPrimaryKeyEnabled(field)} " +
                        "${isAutoIncrementEnabled(field)} ${isNotNullEnabled(field)} ${isUniqueEnabled(field)}"
                queryBuilder.append(fieldPart.trim())

                isFirst = false
            }
            queryBuilder.append(");")
            return queryBuilder.toString()
        }

        fun insert(value: Any): String {
            val objectAsJson = objectAsJson(value)
            val queryBuilder = StringBuilder()
            queryBuilder.append("INSERT INTO ${value.javaClass.simpleName}")

            val keyBuilder: StringBuilder = StringBuilder("(")
            val valueBuilder: StringBuilder = StringBuilder(" VALUES(")

            var isFirst = true
            for (field in value.javaClass.declaredFields) {
                if (isAutoIncrement(field))
                    continue

                if (isFirst.not()) {
                    keyBuilder.append(",")
                    valueBuilder.append(",")
                }
                keyBuilder.append("${field.name}")
                if (objectAsJson.get(field.name).isString)
                    valueBuilder.append("'${objectAsJson.getString(field.name, "")}'")
                else if (objectAsJson.get(field.name).isBoolean) {
                    if (objectAsJson.getBoolean(field.name, false))
                        valueBuilder.append("1")
                    else valueBuilder.append("0")
                } else valueBuilder.append(objectAsJson.get(field.name))

                isFirst = false
            }

            keyBuilder.append(")")
            valueBuilder.append(")")

            queryBuilder.append(keyBuilder)
            queryBuilder.append(valueBuilder)
            queryBuilder.append(";")

            log(this.javaClass.simpleName, queryBuilder.toString())
            return queryBuilder.toString()
        }

        fun select(value: Any, condition: PultusORMCondition): String {
            if (condition.rawQuery().trim().isNotEmpty()) {
                if (condition.rawQuery().trim().toLowerCase().startsWith("order"))
                    return "SELECT * FROM ${value.javaClass.simpleName} ${condition.rawQuery().toString()};"
                else return "SELECT * FROM ${value.javaClass.simpleName} WHERE ${condition.rawQuery().toString()};"
            } else return select(value)
        }

        fun select(value: Any): String {
            return "SELECT * FROM ${value.javaClass.simpleName};"
        }

        fun delete(value: Any): String {
            return "DELETE FROM ${value.javaClass.simpleName};"
        }

        fun delete(value: Any, condition: PultusORMCondition): String {
            return "DELETE FROM ${value.javaClass.simpleName} WHERE ${condition.rawQuery()};"
        }

        fun drop(value: Any) {

        }

        fun update(value: Any, updateQuery: PultusORMUpdater): String {
            val query: StringBuilder = StringBuilder()
            query.append("UPDATE ${value.javaClass.simpleName} SET ")
            query.append("${updateQuery.updateQuery()}")
            if (updateQuery.condition() != null)
                query.append(" WHERE ${updateQuery.condition()!!.rawQuery()}")
            query.append(";")

            println(query.toString())
            return query.toString()
        }
    }
}
