package ninja.sakib.pultusorm

import ninja.sakib.pultusorm.callbacks.Callback
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMQuery
import ninja.sakib.pultusorm.exceptions.PultusORMException
import ninja.sakib.pultusorm.models.Student
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * := Coded with love by Sakib Sami on 10/7/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

class PultusORMTest : Callback {
    val pultusORM: PultusORM = PultusORM("univ.db")

    @Before
    fun setUp() {

    }

    @Test
    fun saveTest() {
        val student: Student = Student()
        student.name = "Sakib Sayem"
        student.department = "CSE"
        student.cgpa = 2.3

        pultusORM.save(student)
    }

    @Test
    fun saveTestWithCallback() {
        val student: Student = Student()
        student.name = "Sayem"
        student.department = "CSE"
        student.cgpa = 2.2

        pultusORM.save(student, this)
    }


    override fun onSuccess(type: PultusORMQuery.Type) {

    }

    override fun onFailure(type: PultusORMQuery.Type, exception: PultusORMException) {
        Assert.fail("${type.name} - ${exception.message}")
    }

    @After
    fun tearDown() {

    }
}