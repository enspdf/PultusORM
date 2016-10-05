/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class Test : ninja.sakib.pultusorm.callbacks.Callback {
    override fun onSuccess(type: ninja.sakib.pultusorm.core.PultusORMQuery.Type) {
        ninja.sakib.pultusorm.core.log(this.javaClass.simpleName, "${type.name} Succeed")
    }

    override fun onFailure(type: ninja.sakib.pultusorm.core.PultusORMQuery.Type, exception: ninja.sakib.pultusorm.exceptions.PultusORMException) {
        ninja.sakib.pultusorm.core.log(this.javaClass.simpleName, "${type.name} Failed <${exception.message}>")
        exception.printStackTrace()
    }
}

fun main(args: Array<String>) {
    val pultusORM: ninja.sakib.pultusorm.core.PultusORM = ninja.sakib.pultusorm.core.PultusORM("test", "/Users/s4kib/")

//    val user: User = User()
////    user.userId = Math.abs(UUID.randomUUID().mostSignificantBits.toInt())
//    user.name = "Sakib"
//    user.age = 25
//    pultusORM.save(user, Test())

//    val condition: PultusORMCondition = PultusORMCondition()
//    condition.eq("userId", 802505126)
//    condition.and()
//    condition.eq("age", 24)

//    val updater: PultusORMUpdater = PultusORMUpdater()
//    updater.set("name", "Sami")
//    updater.condition(condition)
//
//    pultusORM.update(User(), updater)

//    val result: MutableList<Any> = pultusORM.get(User(), condition)
//    for (it in result) {
//        val user: User = it as User
//        println("${user.userId}")
//        println("${user.name}")
//        println("${user.age}")
//        println()
//    }

    val condition: ninja.sakib.pultusorm.core.PultusORMCondition = ninja.sakib.pultusorm.core.PultusORMCondition()
    condition.eq("userId", 12)

    pultusORM.delete(ninja.sakib.pultusorm.models.User(), condition, Test())
}
