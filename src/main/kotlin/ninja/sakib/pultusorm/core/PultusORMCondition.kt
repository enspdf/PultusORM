package ninja.sakib.pultusorm.core

/**
 * := Coded with love by Sakib Sami on 10/3/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

/**
 * PultusORMCondition
 * Class used to provide condition on queries
 */
class PultusORMCondition private constructor(builder: Builder) {
    private var rawQuery: String = ""

    init {
        rawQuery = builder.rawQuery()
    }

    /**
     * Method to get query as String
     * @return String
     */
    fun rawQuery(): String {
        return rawQuery
    }

    /**
     * Builder class used to
     * create condition query
     */
    class Builder {
        private var conditionQuery: StringBuilder = StringBuilder() // Condition Queries
        private var sortQuery: StringBuilder = StringBuilder()  // Sort Queries
        private var groupQuery: StringBuilder = StringBuilder() // Group Queries

        /**
         * Method to add equal condition
         * @param key field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun eq(key: String, value: Any): Builder {
            addSeparator()

            if (value is String)
                conditionQuery.append("$key = '$value'")
            else conditionQuery.append("$key = $value")
            return this
        }

        /**
         * Method to add not equal condition
         * @param key field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun notEq(key: String, value: Any): Builder {
            addSeparator()

            if (value is String)
                conditionQuery.append("$key != '$value'")
            else conditionQuery.append("$key != $value")
            return this
        }

        /**
         * Method to add between condition
         * @param begin start value
         * @param end end value
         * @return Builder with contacted current condition
         */
        fun between(begin: Int, end: Int): Builder {
            addSeparator()

            conditionQuery.append("BETWEEN $begin AND $end")
            return this
        }

        /**
         * Method to add in condition
         * @param begin start value
         * @param end end value
         * @return Builder with contacted current condition
         */
        fun In(begin: Int, end: Int): Builder {
            addSeparator()

            conditionQuery.append("IN($begin,$end)")
            return this
        }

        /**
         * Method to add between condition
         * @param begin start value
         * @param end end value
         * @return Builder with contacted current condition
         */
        fun notIn(begin: Int, end: Int): Builder {
            addSeparator()

            conditionQuery.append("NOT IN($begin,$end)")
            return this
        }

        /**
         * Method to add and clause
         * @return Builder with contacted current condition
         */
        fun and(): Builder {
            addSeparator()

            conditionQuery.append("AND")
            return this
        }

        /**
         * Method to add or clause
         * @return Builder with contacted current condition
         */
        fun or(): Builder {
            addSeparator()

            conditionQuery.append("OR")
            return this
        }

        /**
         * Method to concat condition with first bracket using OR
         * @param condition
         * @return Builder with contacted current condition
         */
        fun or(condition: Builder): Builder {
            addSeparator()

            conditionQuery.append("OR (${condition.conditionQuery.toString()})")
            return this
        }

        /**
         * Method to concat condition with first bracket using AND
         * @param condition
         * @return Builder with contacted current condition
         */
        fun and(condition: Builder): Builder {
            addSeparator()

            conditionQuery.append("AND (${condition.conditionQuery.toString()})")
            return this
        }

        /**
         * Method to add greater condition
         * @param key field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun greater(key: String, value: Int): Builder {
            addSeparator()

            conditionQuery.append("$key > $value")
            return this
        }

        /**
         * Method to add less condition
         * @param key field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun less(key: String, value: Int): Builder {
            addSeparator()

            conditionQuery.append("$key < $value")
            return this
        }

        /**
         * Method to add greater or equal condition
         * @param key field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun greaterEq(key: String, value: Int): Builder {
            addSeparator()

            conditionQuery.append("$key >= $value")
            return this
        }

        /**
         * Method to add less or equal condition
         * @param key field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun lessEq(key: String, value: Int): Builder {
            addSeparator()

            conditionQuery.append("$key <= $value")
            return this
        }

        /**
         * Method to add sort condition
         * @param fieldName field name
         * @param order ordering type
         * @return Builder with contacted current condition
         */
        fun sort(fieldName: String, order: PultusORMQuery.Sort): Builder {
            if (sortQuery.isNotEmpty())
                sortQuery.append(",")

            when (order) {
                PultusORMQuery.Sort.ASCENDING -> {
                    addSeparator()

                    sortQuery.append("$fieldName ASC")
                }
                PultusORMQuery.Sort.DESCENDING -> {
                    addSeparator()

                    sortQuery.append("$fieldName DESC")
                }
            }
            return this
        }

        /**
         * Method to add group by condition
         * @param fieldName field name
         * @return Builder with contacted current condition
         */
        fun group(fieldName: String): Builder {
            if (groupQuery.isNotEmpty())
                groupQuery.append(",")

            groupQuery.append("$fieldName")
            return this
        }

        /**
         * Method to add search condition
         * @param fieldName field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun startsWith(fieldName: String, value: Any): Builder {
            addSeparator()

            conditionQuery.append("$fieldName LIKE '$value%'")
            return this
        }

        /**
         * Method to add search condition
         * @param fieldName field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun endsWith(fieldName: String, value: Any): Builder {
            addSeparator()

            conditionQuery.append("$fieldName LIKE '%$value'")
            return this
        }

        /**
         * Method to add search condition
         * @param fieldName field name
         * @param value field value
         * @return Builder with contacted current condition
         */
        fun contains(fieldName: String, value: Any): Builder {
            addSeparator()

            conditionQuery.append("$fieldName LIKE '%$value%'")
            return this
        }

        /**
         * Method to create final query as String
         * @return String
         */
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

        /**
         * Method build condition and
         * return it
         */
        fun build(): PultusORMCondition {
            return PultusORMCondition(this)
        }

        private fun addSeparator() {
            if (conditionQuery.isNotEmpty())
                conditionQuery.append(" ")
        }
    }
}
