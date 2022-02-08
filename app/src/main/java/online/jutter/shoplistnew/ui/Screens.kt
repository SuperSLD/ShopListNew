package online.jutter.shoplistnew.ui

import online.jutter.shoplistnew.ui.shoplist.FlowMainFragment
import online.jutter.shoplistnew.ui.shoplist.ShopListFragment
import online.jutter.shoplistnew.ui.shoplist.crete.CreateFragment
import online.jutter.shoplistnew.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    /** Глобальный роутер */
    object FlowGlobal: SupportAppScreen() {
        override fun getFragment() = FlowGlobalFragment()
    }

    object Splash: SupportAppScreen() {
        override fun getFragment() = SplashFragment()
    }

    /** Список покупок */
    object FlowMain: SupportAppScreen() {
        override fun getFragment() = FlowMainFragment()
    }

    object ShopList: SupportAppScreen() {
        override fun getFragment() = ShopListFragment()
    }

    object Create: SupportAppScreen() {
        override fun getFragment() = CreateFragment()
    }
}