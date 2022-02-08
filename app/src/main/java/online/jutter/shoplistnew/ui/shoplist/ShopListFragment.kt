package online.jutter.shoplistnew.ui.shoplist

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_shop_list.*
import online.jutter.shoplistnew.R
import online.jutter.supersld.common.base.BaseFragment

class ShopListFragment : BaseFragment(R.layout.fragment_shop_list), MvpView {

    @InjectPresenter
    lateinit var presenter: ShopListPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvDefault.setOnClickListener {
            presenter.onCreateOpen()
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}