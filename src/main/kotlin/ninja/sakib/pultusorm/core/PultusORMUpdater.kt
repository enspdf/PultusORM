package ninja.sakib.pultusorm.core

/**
 * := Coded with love by Sakib Sami on 10/5/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

/**
 * PultusORMUpdater
 * Class used to update value of fields
 */
class PultusORMUpdater private constructor(condition: PultusORMCondition?, updateQuery: StringBuilder) {
    private var condition: PultusORMCondition? = null
    private var updateQuery: StringBuilder = StringBuilder()

    init {
        this.condition = condition
        this.updateQuery = updateQuery
    }

    /**
     * Method to get condition
     * which will be used to
     * update value of fields
     * @return PultusORMCondition
     */
    fun condition(): PultusORMCondition? {
        return condition
    }

    /**
     * Method to get update query
     * which will be used to
     * update value of fields
     * @return String
     */
    fun updateQuery(): String {
        return updateQuery.toString()
    }

    /**
     * Builder class is to create updater
     */
    class Builder {
        private var condition: PultusORMCondition? = null
        private val updateQuery: StringBuilder = StringBuilder()

        /**
         *  Method to add field name and new value
         *  @param fieldName name of field to update value
         *  @param newValue new value of the field
         *  return Builder
         */
        fun set(fieldName: String, newValue: Any): Builder {
            addSeparator()

            if (newValue is String)
                updateQuery.append("$fieldName = '$newValue'")
            else updateQuery.append("$fieldName = $newValue")
            return this
        }

        /**
         * Method to add update condition
         * @param condition on which condition values will be updated
         * @return Builder
         */
        fun condition(condition: PultusORMCondition): Builder {
            this.condition = condition
            return this
        }

        /**
         * Method to build updater
         * @return PultusORMUpdater
         */
        fun build(): PultusORMUpdater {
            return PultusORMUpdater(condition, updateQuery)
        }

        private fun addSeparator() {
            if (updateQuery.trim().isNotEmpty())
                updateQuery.append(", ")
        }
    }
}
