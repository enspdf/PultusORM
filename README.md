## PultusORM
PultusORM is a sqlite ORM library for kotlin on top of sqlite jdbc driver.

status : active<br>
version : beta-0.0.4

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
    compile 'com.github.s4kibs4mi:PultusORM:beta-0.0.4'
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
    <version>beta-0.0.4</version>
</dependency>
```

In case you need jar [download](https://jitpack.io/com/github/s4kibs4mi/PultusORM/beta-0.0.4/PultusORM-beta-0.0.4.jar).

[More option...](https://jitpack.io/#s4kibs4mi/PultusORM/beta-0.0.4)

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
val condition: PultusORMCondition = PultusORMCondition.Builder()
        .eq("userId", 802505126)
        .and()     // Concating two condition with and
        .eq("age", 24)
        .or()
        .startsWith("name", "sami")
        .sort("age", PultusORMQuery.Sort.DESCENDING)
        .build()

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
val condition: PultusORMCondition = PultusORMCondition.Builder()
        .eq("userId", 802505126)
        .build()

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

**Check [Wiki](https://github.com/s4kibs4mi/PultusORM/wiki) for more examples & API docs**

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
