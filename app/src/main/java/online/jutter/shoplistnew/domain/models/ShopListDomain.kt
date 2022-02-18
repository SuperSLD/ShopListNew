package online.jutter.shoplistnew.domain.models

data class ShopListDomain(
    val id: String,
    var name: String,
    val positions: MutableList<PositionDomain>,
    val timestamp: Long,
)

data class PositionDomain(
    var id: String,
    var name: String,
    var mes: String,
    var count: Int,
    var selected: Boolean,
)