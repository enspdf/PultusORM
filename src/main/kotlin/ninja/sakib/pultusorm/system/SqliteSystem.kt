package ninja.sakib.pultusorm.system

/**
 * := Coded with love by Sakib Sami on 9/28/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class SqliteSystem {
    enum class Type {
        TABLE,
        COLUMN
    }

    companion object {
        fun getTableName(): String {
            return "sqlite_master"
        }

        fun getTempTableName(): String {
            return "sqlite_temp_master"
        }
    }
}