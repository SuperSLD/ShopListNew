package online.jutter.shoplistnew.ui.shoplist.crete

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.shoplistnew.R
import online.jutter.supersld.common.base.BaseFragment

class CreateFragment : BaseFragment(R.layout.fragment_create), MvpView {

    @InjectPresenter
    lateinit var presenter: CreatePresenter

    override fun onBackPressed() {
        presenter.back()
    }
}