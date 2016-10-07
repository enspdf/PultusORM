package ninja.sakib.pultusorm

import ninja.sakib.pultusorm.callbacks.Callback
import ninja.sakib.pultusorm.core.*
import ninja.sakib.pultusorm.exceptions.PultusORMException
import ninja.sakib.pultusorm.models.Student

/**
 * := Coded with love by Sakib Sami on 9/27/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class ResponseCallback : Callback {
    override fun onSuccess(type: PultusORMQuery.Type) {
        log("${type.name}", "Success")
    }

    override fun onFailure(type: PultusORMQuery.Type, exception: PultusORMException) {
        log("${type.name}", "Failure")
        exception.printStackTrace()
    }
}

fun main(args: Array<String>) {
    enableDebugMode(true)

    val pultusORM: PultusORM = PultusORM("univ.db")
    println(pultusORM.count(Student()))

//    val student: Student = Student()
//    student.name = "Sakib Sami"
//    student.department = "ETE"
//    student.cgpa = 2.5
//
//    pultusORM.save(student, ResponseCallback())

    val condition: PultusORMCondition = PultusORMCondition()
    condition.sort("department", PultusORMQuery.Sort.DESCENDING)
//    condition.group("department")
//    condition.group("name")

    val students: MutableList<Any> = pultusORM.get(Student(), condition)
    for (it in students) {
        val std = it as Student
        println("${std.studentId}")
        println("${std.name}")
        println("${std.department}")
        println("${std.cgpa}")
    }
}
