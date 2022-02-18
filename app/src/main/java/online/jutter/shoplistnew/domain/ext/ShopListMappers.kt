package online.jutter.shoplistnew.domain.ext

import online.jutter.shoplistnew.data.ext.toRealmList
import online.jutter.shoplistnew.data.ext.toStringRealmList
import online.jutter.shoplistnew.data.models.PositionRealm
import online.jutter.shoplistnew.data.models.ShopListRealm
import online.jutter.shoplistnew.domain.models.PositionDomain
import online.jutter.shoplistnew.domain.models.ShopListDomain
import java.util.*

fun PositionDomain.toRealm() = PositionRealm(
    id = id,
    name = name,
    mes = mes,
    count = count,
    selected = selected,
)

fun PositionRealm.toDomain() = PositionDomain(
    id = id,
    name = name,
    mes = mes,
    count = count,
    selected = selected,
)

fun ShopListDomain.toRealm() = ShopListRealm(
    id = id,
    name = name,
    timestamp = timestamp,
    positions = positions.map { it.toRealm() }.toRealmList(),
)

fun ShopListRealm.toDomain() = ShopListDomain(
    id = id,
    name = name,
    timestamp = timestamp,
    positions = positions.map { it.toDomain() }.toMutableList(),
)