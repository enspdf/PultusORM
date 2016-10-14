[pultusorm](../../index.md) / [ninja.sakib.pultusorm.core](../index.md) / [PultusORM](.)

# PultusORM

`class PultusORM`

Base class of PultusORM API
It handles database connection
and serves queries

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PultusORM(databaseName: String)`<br>Constructor to initialize class with database name
In this case user home path will be used as database path`PultusORM(databaseName: String, databasePath: String)`<br>Constructor to initialize class with database name &amp; database path |

### Functions

| Name | Summary |
|---|---|
| [count](count.md) | `fun count(clazz: Any): Long`<br>Method to get number of objects of a specific type |
| [delete](delete.md) | `fun delete(clazz: Any): Unit`<br>Method to delete data of specific clazz`fun delete(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`): Unit`<br>Method to delete data of specific clazz based on condition`fun delete(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to delete data of specific clazz with callback`fun delete(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to delete data of specific clazz based on condition with callback |
| [drop](drop.md) | `fun drop(clazz: Any): Unit`<br>Method to drop table`fun drop(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to drop table with callback |
| [find](find.md) | `fun find(clazz: Any): MutableList<Any>`<br>Method to get data of specific clazz`fun find(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`): MutableList<Any>`<br>Method to get data of specific clazz based of provided condition |
| [get](get.md) | `fun ~~get~~(clazz: Any): MutableList<Any>`<br>Method to get data of specific clazz
Its deprecated use find method instead`fun ~~get~~(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`): MutableList<Any>`<br>Method to get data of specific clazz based of provided condition
Its deprecated use find method instead |
| [save](save.md) | `fun save(clazz: Any): Unit`<br>Method to save data`fun save(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to save data with callback |
| [update](update.md) | `fun update(clazz: Any, updater: `[`PultusORMUpdater`](../-pultus-o-r-m-updater/index.md)`): Unit`<br>Method to update value`fun update(clazz: Any, updater: `[`PultusORMUpdater`](../-pultus-o-r-m-updater/index.md)`, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`<br>Method to update value with callback async |
