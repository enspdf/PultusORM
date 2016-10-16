# PultusORM [![](https://jitpack.io/v/ninja.sakib/PultusORM.svg)](https://jitpack.io/#ninja.sakib/PultusORM)
PultusORM is a sqlite ORM library for kotlin & Android.

Status : Active<br>

##
Features Implemented,
* Insert
* Retrieve
* Update
* Delete
* Drop


### Usages
In your build file add
##### Gradle
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
And
```
dependencies {
    compile 'ninja.sakib:PultusORM:beta-0.0.6'
}
```

##### Maven
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
	</repository>
</repositories>
```
And
```
<dependency>
    <groupId>ninja.sakib</groupId>
    <artifactId>PultusORM</artifactId>
    <version>beta-0.0.6</version>
</dependency>
```

In case you need jar [download](https://jitpack.io/ninja/sakib/PultusORM/beta-0.0.6/PultusORM-beta-0.0.6.jar).

[More option...](https://jitpack.io/#ninja.sakib/PultusORM/beta-0.0.6)

### Examples

##### Insert Value
```
class Student {
    @PrimaryKey
    @AutoIncrement
    var studentId: Int = 0
    var name: String? = null
    var department: String? = null
    var cgpa: Double = 0.0
}

val pultusORM: PultusORM = PultusORM("test.db", "/Users/s4kib/")

val student: Student = Student()
student.name = "Sakib Sayem"
student.department = "CSE"
student.cgpa = 2.3
pultusORM.save(student)
```

##### Retrieve Value
```
val students = pultusORM.find(Student())
for (it in students) {
    val student = it as Student
    println(student.studentId)
    println(student.name)
    println(student.department)
    println(student.cgpa)
    println()
}
```

###### Result
1<br>
Sakib Sayem<br>
CSE
2.3

##### Retrieve Value based on condition
```
val condition: PultusORMCondition = PultusORMCondition.Builder()
            .eq("name", "sakib")
            .and()
            .greaterEq("cgpa", 18)
            .or()
            .startsWith("name", "sami")
            .sort("name", PultusORMQuery.Sort.DESCENDING)
            .sort("department", PultusORMQuery.Sort.ASCENDING)
            .build()

val students = pultusORM.find(Student(), condition)
for (it in students) {
    val student = it as Student
    println("${student.studentId}")
    println("${student.name}")
}
```

##### Update Value
```
// values will be updated based on this condition
val condition: PultusORMCondition = PultusORMCondition.Builder()
            .eq("name", "Sakib")
            .build()

val updater: PultusORMUpdater = PultusORMUpdater.Builder()
            .set("name", "Sayan Nur")
            .condition(condition)   // condition is optional
            .build()

pultusORM.update(Student(), updater)
```

##### Delete Value
```
pultusORM.delete(Student())
```

**Check [Wiki](https://github.com/s4kibs4mi/PultusORM/wiki) for more examples & [API docs](https://github.com/s4kibs4mi/PultusORM/blob/master/docs/pultusorm/)**

#
#####Note :
Tables will be created on fly if not exists using class name
and columns based on
class fields.<br>
Currently supported types.
* String
* Int
* Long
* Float
* Double
* Boolean<br>

Autoincrement annotated fields values will be skipped
as that will be handled by sqlite.

### License
Copyright &copy; Sakib Sami<br>
Distributed under [MIT](https://github.com/s4kibs4mi/PultusORM/blob/master/LICENSE) license

### Naming
You may want to know about **Pultus**.<br>
Well that's my GF's name I love to call ;)
