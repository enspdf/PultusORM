package ninja.sakib.pultusorm.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.PrimaryKey

/**
 * := Coded with love by Sakib Sami on 10/6/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class Student {
    @PrimaryKey
    @AutoIncrement
    var studentId: Int = 0
    var name: String? = null
    var department: String? = null
    var cgpa: Double = 0.0
}
