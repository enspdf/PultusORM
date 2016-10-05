package ninja.sakib.pultusorm.callbacks

import ninja.sakib.pultusorm.core.PultusORMQuery
import ninja.sakib.pultusorm.exceptions.PultusORMException

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

interface Callback {
    fun onSuccess(type: PultusORMQuery.Type)
    fun onFailure(type: PultusORMQuery.Type, exception: PultusORMException)
}
