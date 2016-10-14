[pultusorm](../index.md) / [ninja.sakib.pultusorm.core](.)

## Package ninja.sakib.pultusorm.core

### Types

| Name | Summary |
|---|---|
| [PultusORM](-pultus-o-r-m/index.md) | `class PultusORM`<br>Base class of PultusORM API
It handles database connection
and serves queries |
| [PultusORMCondition](-pultus-o-r-m-condition/index.md) | `class PultusORMCondition`<br>PultusORMCondition
Class used to provide condition on queries |
| [PultusORMQuery](-pultus-o-r-m-query/index.md) | `class PultusORMQuery`<br>Base Class of PultusORM API
to execute queries |
| [PultusORMUpdater](-pultus-o-r-m-updater/index.md) | `class PultusORMUpdater`<br>PultusORMUpdater
Class used to update value of fields |

### Properties

| Name | Summary |
|---|---|
| [isDebugEnabled](is-debug-enabled.md) | `var isDebugEnabled: Boolean`<br>:= Coded with love by Sakib Sami on 9/27/16.
:= s4kibs4mi@gmail.com
:= www.sakib.ninja
:= Coffee : Dream : Code |
| [objectToJsonConverter](object-to-json-converter.md) | `val objectToJsonConverter: Gson` |

### Functions

| Name | Summary |
|---|---|
| [enableDebugMode](enable-debug-mode.md) | `fun enableDebugMode(enable: Boolean): Unit`<br>Method to enable/disable debug &amp; logging mode |
| [getUserHomeDirectory](get-user-home-directory.md) | `fun getUserHomeDirectory(): String`<br>Method to get users home directory |
| [isAutoIncrement](is-auto-increment.md) | `fun isAutoIncrement(value: `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`): Boolean`<br>Method to check whether type is auto increment annotated |
| [isBoolean](is-boolean.md) | `fun isBoolean(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is boolean |
| [isChar](is-char.md) | `fun isChar(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is char |
| [isDouble](is-double.md) | `fun isDouble(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is double |
| [isEqual](is-equal.md) | `fun isEqual(x: String, y: String): Boolean`<br>Method to compare string |
| [isFloat](is-float.md) | `fun isFloat(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is float |
| [isInt](is-int.md) | `fun isInt(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is Int |
| [isLong](is-long.md) | `fun isLong(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is long |
| [isPrimaryKey](is-primary-key.md) | `fun isPrimaryKey(value: `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`): Boolean`<br>Method to check whether type is primary key annotated |
| [isString](is-string.md) | `fun isString(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Method to check whether type is String |
| [jsonAsObject](json-as-object.md) | `fun jsonAsObject(clazz: Any, value: JsonObject): Any`<br>Method to convert json to object |
| [log](log.md) | `fun log(key: String, value: String): Unit`<br>Method to log something to console |
| [objectAsJson](object-as-json.md) | `fun objectAsJson(value: Any): JsonObject`<br>Method to convert object to json via Gson |
| [parseClassName](parse-class-name.md) | `fun parseClassName(value: Any): String`<br>Method to parse class name from object |
| [throwback](throwback.md) | `fun throwback(msg: String): Unit`<br>Method to throw exception |
| [toAutoIncrement](to-auto-increment.md) | `fun toAutoIncrement(value: `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`): String`<br>Method to convert auto increment annotation to sql text |
| [toNotNull](to-not-null.md) | `fun toNotNull(value: `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`): String`<br>Method to convert not null to sql text |
| [toPrimaryKey](to-primary-key.md) | `fun toPrimaryKey(value: `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`): String`<br>Method to convert primary key annotation to sql text |
| [toUnique](to-unique.md) | `fun toUnique(value: `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`): String`<br>Method to convert unique to sql text |
| [typeToSQL](type-to-s-q-l.md) | `fun typeToSQL(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): String`<br>Method to convert primitive types to sql string |
