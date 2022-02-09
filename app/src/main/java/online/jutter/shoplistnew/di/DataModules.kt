package online.jutter.shoplistnew.di

import io.realm.Realm
import io.realm.RealmConfiguration
import online.jutter.shoplistnew.data.repositories.ShopListRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module

fun Module.provideDataFlow() {
    single {
        Realm.init(androidContext())
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .name("shopList_app.db")
            .build()
        Realm.getInstance(config)
    }
    single { ShopListRepository(get()) }
}
