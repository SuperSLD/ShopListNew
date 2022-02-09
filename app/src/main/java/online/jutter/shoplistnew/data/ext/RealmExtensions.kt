package online.jutter.shoplistnew.data.ext

import io.realm.RealmList
import io.realm.RealmObject

/**
 * Переход от списка к реалм списку.
 */
fun <T : RealmObject> List<T>.toRealmList(): RealmList<T> {
    val result = RealmList<T>()
    forEach { result.add(it) }
    return result
}

fun List<String>.toStringRealmList(): RealmList<String> {
    val result = RealmList<String>()
    forEach { result.add(it) }
    return result
}
