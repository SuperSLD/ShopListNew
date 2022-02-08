package online.jutter.shoplistnew.ui.splash

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.delay
import online.jutter.shoplistnew.ui.Screens
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI

@InjectViewState
class SplashPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        start()
    }

    private fun start() {
        launchIO {
            delay(2000)
            withUI {
                router?.newRootScreen(Screens.FlowMain)
            }
        }
    }

    fun back() {
        router?.exit()
    }
}