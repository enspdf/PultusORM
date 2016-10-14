package ninja.sakib.pultusorm.callbacks

import ninja.sakib.pultusorm.core.PultusORMQuery
import ninja.sakib.pultusorm.exceptions.PultusORMException

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

/**
 * Interface to get callback on async query
 */

interface Callback {
    /**
     * @param type this is to indicate on which task firing this callback
     */
    fun onSuccess(type: PultusORMQuery.Type)

    /**
     * @param type this is to indicate on which task firing this callback
     * @param exception failure information
     */
    fun onFailure(type: PultusORMQuery.Type, exception: PultusORMException)
}
