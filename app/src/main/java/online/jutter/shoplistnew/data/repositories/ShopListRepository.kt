package online.jutter.shoplistnew.data.repositories

import io.realm.Realm
import online.jutter.shoplistnew.data.models.ShopListRealm

class ShopListRepository(
    private val realm: Realm,
) {

    fun addOrUpdateShopList(shopList: ShopListRealm) = with(realm) {
        executeTransaction {
            copyToRealmOrUpdate(shopList)
        }
    }

    fun getAll() : MutableList<ShopListRealm> {
        val cart = mutableListOf<ShopListRealm>()
        with(realm) {
            cart.addAll(where(ShopListRealm::class.java).findAll())
        }
        return cart
    }
}