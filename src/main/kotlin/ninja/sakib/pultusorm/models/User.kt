package ninja.sakib.pultusorm.models

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.NotNull
import ninja.sakib.pultusorm.annotations.PrimaryKey

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class User() {
    @PrimaryKey
    @AutoIncrement
    var userId: Int = 0
    @NotNull
    var name: String? = null
    var age: Int = 0
}
