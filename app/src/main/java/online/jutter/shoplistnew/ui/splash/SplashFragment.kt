package online.jutter.shoplistnew.ui.splash
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.shoplistnew.R
import online.jutter.supersld.common.base.BaseFragment

class SplashFragment : BaseFragment(R.layout.fragment_splash), MvpView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    override fun onBackPressed() {
        presenter.back()
    }
}
