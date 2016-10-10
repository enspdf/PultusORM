package ninja.sakib.pultusorm.core

/**
 * := Coded with love by Sakib Sami on 10/3/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMCondition {
    private var conditionQuery: StringBuilder = StringBuilder()
    private var sortQuery: StringBuilder = StringBuilder()
    private var groupQuery: StringBuilder = StringBuilder()

    fun eq(key: String, value: Any): PultusORMCondition {
        addSeparator()

        if (value is String)
            conditionQuery.append("$key = '$value'")
        else conditionQuery.append("$key = $value")
        return this
    }

    fun notEq(key: String, value: Any): PultusORMCondition {
        addSeparator()

        if (value is String)
            conditionQuery.append("$key != '$value'")
        else conditionQuery.append("$key != $value")
        return this
    }

    fun between(begin: Int, end: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("BETWEEN $begin AND $end")
        return this
    }

    fun In(begin: Int, end: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("IN($begin,$end)")
        return this
    }

    fun notIn(begin: Int, end: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("NOT IN($begin,$end)")
        return this
    }

    fun and(): PultusORMCondition {
        addSeparator()

        conditionQuery.append("AND")
        return this
    }

    fun or(): PultusORMCondition {
        addSeparator()

        conditionQuery.append("OR")
        return this
    }

    fun or(condition: PultusORMCondition): PultusORMCondition {
        addSeparator()

        conditionQuery.append("OR (${condition.conditionQuery.toString()})")
        return this
    }

    fun greater(key: String, value: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$key > $value")
        return this
    }

    fun less(key: String, value: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$key < $value")
        return this
    }

    fun greaterEq(key: String, value: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$key >= $value")
        return this
    }

    fun lessEq(key: String, value: Int): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$key <= $value")
        return this
    }

    fun sort(columnName: String, order: PultusORMQuery.Sort): PultusORMCondition {
        if (sortQuery.isNotEmpty())
            sortQuery.append(",")

        when (order) {
            PultusORMQuery.Sort.ASCENDING -> {
                addSeparator()

                sortQuery.append("$columnName ASC")
            }
            PultusORMQuery.Sort.DESCENDING -> {
                addSeparator()

                sortQuery.append("$columnName DESC")
            }
        }
        return this
    }

    fun group(columnName: String): PultusORMCondition {
        if (groupQuery.isNotEmpty())
            groupQuery.append(",")
        groupQuery.append("$columnName")
        return this
    }

    fun startsWith(columnName: String, value: Any): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$columnName LIKE '$value%'")
        return this
    }

    fun endsWith(columnName: String, value: Any): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$columnName LIKE '%$value'")
        return this
    }

    fun contains(columnName: String, value: Any): PultusORMCondition {
        addSeparator()

        conditionQuery.append("$columnName LIKE '%$value%'")
        return this
    }

    fun rawQuery(): String {
        val query: StringBuilder = StringBuilder()
        if (conditionQuery.isNotEmpty())
            query.append("WHERE ${conditionQuery.toString()}")

        if (query.isNotEmpty())
            query.append(" ")

        if (groupQuery.isNotEmpty())
            query.append("GROUP BY ${groupQuery.toString()}")

        if (query.isNotEmpty())
            query.append(" ")

        if (sortQuery.isNotEmpty())
            query.append("ORDER BY ${sortQuery.toString()}")

        return query.toString()
    }

    private fun addSeparator() {
        if (conditionQuery.isNotEmpty())
            conditionQuery.append(" ")
    }
}
