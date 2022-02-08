package online.jutter.shoplistnew.di

import org.koin.dsl.module

fun provideAppModules() = module{
    provideUeeCases()
    provideDataFlow()
}