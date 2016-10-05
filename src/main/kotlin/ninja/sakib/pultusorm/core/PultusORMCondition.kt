package ninja.sakib.pultusorm.core

/**
 * := Coded with love by Sakib Sami on 10/3/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMCondition {
    private var query: StringBuilder = StringBuilder()

    fun eq(key: String, value: Any) {
        addSeparator()

        if (value is String)
            query.append("$key = '$value'")
        else query.append("$key = $value")
    }

    fun notEq(key: String, value: Any) {
        addSeparator()

        if (value is String)
            query.append("$key != '$value'")
        else query.append("$key != $value")
    }

    fun between(begin: Int, end: Int) {
        addSeparator()
        query.append("$begin AND $end")
    }

    fun In(begin: Int, end: Int) {
        addSeparator()
        query.append("IN($begin,$end)")
    }

    fun notIn(begin: Int, end: Int) {
        addSeparator()
        query.append("NOT IN($begin,$end)")
    }

    fun and() {
        addSeparator()
        query.append("AND")
    }

    fun or(condition: PultusORMCondition) {
        addSeparator()

        query.append("OR (${condition.query.toString()})")
    }

    fun greater(key: String, value: Int) {
        addSeparator()

        query.append("$key > $value")
    }

    fun less(key: String, value: Int) {
        addSeparator()

        query.append("$key < $value")
    }

    fun greaterEq(key: String, value: Int) {
        addSeparator()

        query.append("$key >= $value")
    }

    fun lessEq(key: String, value: Int) {
        addSeparator()

        query.append("$key <= $value")
    }

    fun sort(columnName: String, order: PultusORMQuery.Sort) {
        when (order) {
            PultusORMQuery.Sort.ASCENDING -> {
                addSeparator()

                query.append("ORDER BY $columnName ASC")
            }
            PultusORMQuery.Sort.DESCENDING -> {
                addSeparator()

                query.append("ORDER BY $columnName DESC")
            }
        }
    }

    fun rawQuery(): String {
        return query.toString()
    }

    fun rawQuery(rawQuery: String) {
        query = StringBuilder()
        query.append(rawQuery)
    }

    private fun addSeparator() {
        if (query.isNotEmpty())
            query.append(" ")
    }
}
