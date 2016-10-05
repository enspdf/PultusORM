package ninja.sakib.pultusorm.core

/**
 * := Coded with love by Sakib Sami on 10/5/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMUpdater {
    private var condition: PultusORMCondition? = null
    private val updateQuery: StringBuilder = StringBuilder()

    fun set(columnName: String, newValue: Any) {
        addSeparator()

        if (newValue is String)
            updateQuery.append("$columnName = '$newValue'")
        else updateQuery.append("$columnName = $newValue")
    }

    fun condition(condition: PultusORMCondition) {
        this.condition = condition
    }

    fun condition(): PultusORMCondition? {
        return condition
    }

    fun updateQuery(): String {
        return updateQuery.toString()
    }

    private fun addSeparator() {
        if (updateQuery.trim().isNotEmpty())
            updateQuery.append(", ")
    }
}