[pultusorm](../../index.md) / [ninja.sakib.pultusorm.core](../index.md) / [PultusORM](index.md) / [delete](.)

# delete

`fun delete(clazz: Any): Unit`

Method to delete data of specific clazz

### Parameters

`clazz` - which type of data will be deleted

`fun delete(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`): Unit`

Method to delete data of specific clazz based on condition

### Parameters

`clazz` - which type of data will be deleted

`condition` - will be used to delete data

`fun delete(clazz: Any, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`

Method to delete data of specific clazz with callback

### Parameters

`clazz` - which type of data will be deleted

`callback` - will be fired on task complete

`fun delete(clazz: Any, condition: `[`PultusORMCondition`](../-pultus-o-r-m-condition/index.md)`, callback: `[`Callback`](../../ninja.sakib.pultusorm.callbacks/-callback/index.md)`): Unit`

Method to delete data of specific clazz based on condition with callback

### Parameters

`clazz` - which type of data will be deleted

`condition` - will be used to delete data

`callback` - will be fired on task complete