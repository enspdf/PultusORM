package ninja.sakib.pultusorm.exceptions

import java.lang.Exception

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMException(msg: String) : Exception() {
    private var msg: String = ""

    init {
        this.msg = msg
    }

    override val message: String?
        get() = msg
}
