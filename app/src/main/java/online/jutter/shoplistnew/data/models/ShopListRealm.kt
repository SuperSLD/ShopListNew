package online.jutter.shoplistnew.data.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ShopListRealm(
    @PrimaryKey
    var id: String = "",
    var name: String = "",
    var positions: RealmList<String> = RealmList(),
    var timestamp: Long = 0L,
) : RealmObject()