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

    fun eq(key: String, value: Any) {
        addSeparator()

        if (value is String)
            conditionQuery.append("$key = '$value'")
        else conditionQuery.append("$key = $value")
    }

    fun notEq(key: String, value: Any) {
        addSeparator()

        if (value is String)
            conditionQuery.append("$key != '$value'")
        else conditionQuery.append("$key != $value")
    }

    fun between(begin: Int, end: Int) {
        addSeparator()
        conditionQuery.append("BETWEEN $begin AND $end")
    }

    fun In(begin: Int, end: Int) {
        addSeparator()
        conditionQuery.append("IN($begin,$end)")
    }

    fun notIn(begin: Int, end: Int) {
        addSeparator()
        conditionQuery.append("NOT IN($begin,$end)")
    }

    fun and() {
        addSeparator()
        conditionQuery.append("AND")
    }

    fun or() {
        addSeparator()

        conditionQuery.append("OR")
    }

    fun or(condition: PultusORMCondition) {
        addSeparator()

        conditionQuery.append("OR (${condition.conditionQuery.toString()})")
    }

    fun greater(key: String, value: Int) {
        addSeparator()

        conditionQuery.append("$key > $value")
    }

    fun less(key: String, value: Int) {
        addSeparator()

        conditionQuery.append("$key < $value")
    }

    fun greaterEq(key: String, value: Int) {
        addSeparator()

        conditionQuery.append("$key >= $value")
    }

    fun lessEq(key: String, value: Int) {
        addSeparator()

        conditionQuery.append("$key <= $value")
    }

    fun sort(columnName: String, order: PultusORMQuery.Sort) {
        when (order) {
            PultusORMQuery.Sort.ASCENDING -> {
                addSeparator()

                sortQuery.append("ORDER BY $columnName ASC")
            }
            PultusORMQuery.Sort.DESCENDING -> {
                addSeparator()

                sortQuery.append("ORDER BY $columnName DESC")
            }
        }
    }

    fun rawQuery(): String {
        val query: StringBuilder = StringBuilder()
        query.append(conditionQuery.toString())
        if (query.isNotEmpty())
            query.append(" ")
        query.append(sortQuery.toString())

        return query.toString()
    }

    private fun addSeparator() {
        if (conditionQuery.isNotEmpty())
            conditionQuery.append(" ")
    }
}
