[pultusorm](../../../index.md) / [ninja.sakib.pultusorm.core](../../index.md) / [PultusORMCondition](../index.md) / [Builder](.)

# Builder

`class Builder`

Builder class used to
create condition query

### Constructors

| [&lt;init&gt;](-init-.md) | `Builder()`<br>Builder class used to
create condition query |

### Functions

| [In](-in.md) | `fun In(begin: Int, end: Int): Builder`<br>Method to add in condition |
| [and](and.md) | `fun and(): Builder`<br>Method to add and clause`fun and(condition: Builder): Builder`<br>Method to concat condition with first bracket using AND |
| [between](between.md) | `fun between(begin: Int, end: Int): Builder`<br>Method to add between condition |
| [build](build.md) | `fun build(): `[`PultusORMCondition`](../index.md)<br>Method build condition and
return it |
| [contains](contains.md) | `fun contains(fieldName: String, value: Any): Builder`<br>Method to add search condition |
| [endsWith](ends-with.md) | `fun endsWith(fieldName: String, value: Any): Builder`<br>Method to add search condition |
| [eq](eq.md) | `fun eq(key: String, value: Any): Builder`<br>Method to add equal condition |
| [greater](greater.md) | `fun greater(key: String, value: Int): Builder`<br>Method to add greater condition |
| [greaterEq](greater-eq.md) | `fun greaterEq(key: String, value: Int): Builder`<br>Method to add greater or equal condition |
| [group](group.md) | `fun group(fieldName: String): Builder`<br>Method to add group by condition |
| [less](less.md) | `fun less(key: String, value: Int): Builder`<br>Method to add less condition |
| [lessEq](less-eq.md) | `fun lessEq(key: String, value: Int): Builder`<br>Method to add less or equal condition |
| [notEq](not-eq.md) | `fun notEq(key: String, value: Any): Builder`<br>Method to add not equal condition |
| [notIn](not-in.md) | `fun notIn(begin: Int, end: Int): Builder`<br>Method to add between condition |
| [or](or.md) | `fun or(): Builder`<br>Method to add or clause`fun or(condition: Builder): Builder`<br>Method to concat condition with first bracket using OR |
| [rawQuery](raw-query.md) | `fun rawQuery(): String`<br>Method to create final query as String |
| [sort](sort.md) | `fun sort(fieldName: String, order: `[`Sort`](../../-pultus-o-r-m-query/-sort/index.md)`): Builder`<br>Method to add sort condition |
| [startsWith](starts-with.md) | `fun startsWith(fieldName: String, value: Any): Builder`<br>Method to add search condition |

