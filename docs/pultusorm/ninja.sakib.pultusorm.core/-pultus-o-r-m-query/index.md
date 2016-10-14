[pultusorm](../../index.md) / [ninja.sakib.pultusorm.core](../index.md) / [PultusORMQuery](.)

# PultusORMQuery

`class PultusORMQuery`

Base Class of PultusORM API
to execute queries

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `inner class Builder` |
| [Sort](-sort/index.md) | `enum class Sort`<br>Sort Type |
| [Type](-type/index.md) | `enum class Type`<br>Query Type |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PultusORMQuery(connection: `[`Connection`](http://docs.oracle.com/javase/6/docs/api/java/sql/Connection.html)`)`<br>Base Class of PultusORM API
to execute queries |

### Functions

| Name | Summary |
|---|---|
| [count](count.md) | `fun count(clazz: Any): Long`<br>Method to get count of values |
| [delete](delete.md) | `fun delete(clazz: Any): Unit`<br>Method to delete value`fun delete(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`): Unit`<br>Method to delete value based on condition`fun delete(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to delete value with callback`fun delete(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to delete value based on condition with callback |
| [drop](drop.md) | `fun drop(clazz: Any): Unit`<br>Method to delete table`fun drop(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to delete table with callback |
| [get](get.md) | `fun get(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`): MutableList<Any>`<br>Method to get value based on condition`fun get(clazz: Any): MutableList<Any>`<br>Method to get value |
| [save](save.md) | `fun save(clazz: Any): Unit`<br>Method to save value`fun save(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to save value with callback |
| [update](update.md) | `fun update(clazz: Any, updateQuery: `[`PultusORMUpdater`](../-pultus-o-r-m-updater/index.md)`): Unit`<br>Method to update value`fun update(clazz: Any, updateQuery: `[`PultusORMUpdater`](../-pultus-o-r-m-updater/index.md)`, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to update value with callback |
