package online.jutter.shoplistnew.domain.models

data class ShopListDomain(
    val id: String,
    var name: String,
    val positions: MutableList<String>,
    val timestamp: Long,
)