package ninja.sakib.pultusorm

import ninja.sakib.pultusorm.callbacks.Callback
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.PultusORMQuery
import ninja.sakib.pultusorm.core.log
import ninja.sakib.pultusorm.exceptions.PultusORMException
import ninja.sakib.pultusorm.models.User

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class Test : Callback {
    override fun onSuccess(type: PultusORMQuery.Type) {
        log(this.javaClass.simpleName, "${type.name} Succeed")
    }

    override fun onFailure(type: PultusORMQuery.Type, exception: PultusORMException) {
        log(this.javaClass.simpleName, "${type.name} Failed <${exception.message}>")
        exception.printStackTrace()
    }
}

fun main(args: Array<String>) {
    val pultusORM: PultusORM = PultusORM("test", "/Users/s4kib/")

    val user: User = User()
//    user.userId = Math.abs(UUID.randomUUID().mostSignificantBits.toInt())
    user.name = "Sakib"
    user.age = 25
    pultusORM.save(user, ninja.sakib.pultusorm.Test())

//    val condition: PultusORMCondition = PultusORMCondition()
//    condition.eq("userId", 802505126)
//    condition.and()
//    condition.eq("age", 24)

//    val updater: PultusORMUpdater = PultusORMUpdater()
//    updater.set("name", "Sami")
//    updater.condition(condition)
//
//    pultusORM.update(User(), updater)


    val condition: PultusORMCondition = PultusORMCondition()
    condition.sort("userId", PultusORMQuery.Sort.DESCENDING)

    val result: MutableList<Any> = pultusORM.get(User(), condition)
    for (it in result) {
        val user: User = it as User
        println("ID : ${user.userId}")
        println("Name : ${user.name}")
//        println("${user.age}")
        println()
    }

//    pultusORM.delete(User(), condition, Test())
}
