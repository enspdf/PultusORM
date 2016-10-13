package ninja.sakib.pultusorm.core

/**
 * := Coded with love by Sakib Sami on 10/5/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMUpdater private constructor(condition: PultusORMCondition?, updateQuery: StringBuilder) {
    private var condition: PultusORMCondition? = null
    private var updateQuery: StringBuilder = StringBuilder()

    init {
        this.condition = condition
        this.updateQuery = updateQuery
    }

    fun condition(): PultusORMCondition? {
        return condition
    }

    fun updateQuery(): String {
        return updateQuery.toString()
    }

    class Builder {
        private var condition: PultusORMCondition? = null
        private val updateQuery: StringBuilder = StringBuilder()

        fun set(columnName: String, newValue: Any): Builder {
            addSeparator()

            if (newValue is String)
                updateQuery.append("$columnName = '$newValue'")
            else updateQuery.append("$columnName = $newValue")
            return this
        }

        fun condition(condition: PultusORMCondition): Builder {
            this.condition = condition
            return this
        }

        fun build(): PultusORMUpdater {
            return PultusORMUpdater(condition, updateQuery)
        }

        private fun addSeparator() {
            if (updateQuery.trim().isNotEmpty())
                updateQuery.append(", ")
        }
    }
}
