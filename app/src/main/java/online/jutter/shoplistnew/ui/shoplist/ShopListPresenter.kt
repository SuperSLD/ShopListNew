package online.jutter.shoplistnew.ui.shoplist

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.shoplistnew.ui.Screens
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class ShopListPresenter : BasePresenter<MvpView>() {

    fun onCreateOpen() {
        router?.navigateTo(Screens.Create)
    }

    fun back() {
        router?.exit()
    }
}