package online.jutter.shoplistnew.ui.shoplist.crete

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class CreatePresenter : BasePresenter<MvpView>() {

    fun back() {
        router?.exit()
    }
}