package online.jutter.shoplistnew.domain.usecases

import online.jutter.shoplistnew.data.repositories.ShopListRepository
import online.jutter.shoplistnew.domain.ext.toRealm
import online.jutter.shoplistnew.domain.models.ShopListDomain

class SaveShopListUseCase(
    private val shopListRepository: ShopListRepository,
) {

    operator fun invoke(shopList: ShopListDomain) {
        shopListRepository.addOrUpdateShopList(shopList.toRealm())
    }
}