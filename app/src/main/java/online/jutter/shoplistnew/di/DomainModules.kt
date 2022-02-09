package online.jutter.shoplistnew.di

import online.jutter.shoplistnew.domain.usecases.GetAllShopListsUseCase
import online.jutter.shoplistnew.domain.usecases.SaveShopListUseCase
import org.koin.core.module.Module

fun Module.provideUeeCases() {
    single { SaveShopListUseCase(get()) }
    single { GetAllShopListsUseCase(get()) }
}
