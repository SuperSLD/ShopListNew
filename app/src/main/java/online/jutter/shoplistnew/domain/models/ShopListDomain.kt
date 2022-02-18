package online.jutter.shoplistnew.domain.models

data class ShopListDomain(
    val id: String,
    var name: String,
    val positions: MutableList<PositionDomain>,
    val timestamp: Long,
)

open class PositionDomain(
    var id: String = "",
    var name: String = "",
    var count: Int = 0,
    var selected: Boolean = false
)