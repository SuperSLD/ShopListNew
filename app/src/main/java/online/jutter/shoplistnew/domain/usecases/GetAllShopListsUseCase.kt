package online.jutter.shoplistnew.domain.usecases

import online.jutter.shoplistnew.data.repositories.ShopListRepository
import online.jutter.shoplistnew.domain.ext.toDomain
import online.jutter.shoplistnew.domain.ext.toRealm
import online.jutter.shoplistnew.domain.models.ShopListDomain

class GetAllShopListsUseCase(
    private val shopListRepository: ShopListRepository,
) {

    operator fun invoke() = shopListRepository.getAll().map {
        it.toDomain()
    }.sortedBy {
        -it.timestamp
    }
}