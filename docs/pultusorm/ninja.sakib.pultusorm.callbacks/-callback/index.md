[pultusorm](../../index.md) / [ninja.sakib.pultusorm.callbacks](../index.md) / [Callback](.)

# Callback

`interface Callback`

Interface to get callback on async query

### Functions

| Name | Summary |
|---|---|
| [onFailure](on-failure.md) | `abstract fun onFailure(type: `[`Type`](../../ninja.sakib.pultusorm.core/-pultus-o-r-m-query/-type/index.md)`, exception: `[`PultusORMException`](../../ninja.sakib.pultusorm.exceptions/-pultus-o-r-m-exception/index.md)`): Unit`<br>Method will be called on failure of task |
| [onSuccess](on-success.md) | `abstract fun onSuccess(type: `[`Type`](../../ninja.sakib.pultusorm.core/-pultus-o-r-m-query/-type/index.md)`): Unit`<br>Method will be called on successful task |
