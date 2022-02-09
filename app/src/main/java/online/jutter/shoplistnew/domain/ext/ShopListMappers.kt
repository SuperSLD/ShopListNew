package online.jutter.shoplistnew.domain.ext

import online.jutter.shoplistnew.data.ext.toStringRealmList
import online.jutter.shoplistnew.data.models.ShopListRealm
import online.jutter.shoplistnew.domain.models.ShopListDomain

fun ShopListDomain.toRealm() = ShopListRealm(
    id = id,
    name = name,
    timestamp = timestamp,
    positions = positions.toStringRealmList(),
)

fun ShopListRealm.toDomain() = ShopListDomain(
    id = id,
    name = name,
    timestamp = timestamp,
    positions = positions.toMutableList(),
)