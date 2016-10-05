## PultusORM
PultusORM is a sqlite ORM library for kotlin on top of sqlite jdbc driver.

Dev status : Active<br>
Current Version : beta-0.0.1

##
Features Implemented,
* Insert
* Retrieve
* Update
* Delete


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
    compile 'com.github.s4kibs4mi:PultusORM:beta-0.0.2'
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
    <groupId>com.github.s4kibs4mi</groupId>
    <artifactId>PultusORM</artifactId>
    <version>beta-0.0.2</version>
</dependency>
```

[More...](https://jitpack.io/#s4kibs4mi/PultusORM/beta-0.0.2)

### Examples

##### Insert Value
```
class User() {
    @PrimaryKey
    @AutoIncrement
    var userId: Int = 0
    @NotNull
    var name: String? = null
    var age: Int = 0
}

val pultusORM: PultusORM = PultusORM("test.db", "/Users/s4kib/")

val user: User = User()
user.userId = Math.abs(UUID.randomUUID().mostSignificantBits.toInt())
user.name = "Sakib"
user.age = 24
pultusORM.save(user)
```

##### Retrieve Value
```
val result: MutableList<Any> = pultusORM.get(User())
for (it in result) {
    val user: User = it as User
    println("${user.userId}")
    println("${user.name}")
    println("${user.age}")
    println()
}
```

###### Result
90815381<br>
Sakib<br>
24

553825217<br>
Sakib<br>
24

1125692361<br>
Sakib<br>
24

##### Retrieve Value based on condition
```
val condition: PultusORMCondition = PultusORMCondition()
condition.eq("userId", 802505126)
condition.and()     // Concating two condition with and
condition.eq("age", 24)
condition.sort("age", PultusORMQuery.Sort.DESCENDING)   // this must be at the last of condition

val result: MutableList<Any> = pultusORM.get(User(), condition)
for (it in result) {
    val user: User = it as User
    println("${user.userId}")
    println("${user.name}")
    println("${user.age}")
    println()
}
```

##### Update Value
```
// values will be updated based on this condition
val condition: PultusORMCondition = PultusORMCondition()
condition.eq("userId", 802505126)

val updater: PultusORMUpdater = PultusORMUpdater()
updater.set("name", "Sami")
updater.condition(condition)    // condition is optional

pultusORM.update(User(), updater)
```

##### Delete Value
```
val pultusORM: PultusORM = PultusORM("test.db", "/Users/s4kib/")
pultusORM.delete(User())
```

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
Distributed under [Apache 2](https://github.com/s4kibs4mi/PultusORM/blob/master/LICENSE) license
