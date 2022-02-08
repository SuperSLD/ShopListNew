package online.jutter.shoplistnew.ui.shoplist

import android.os.Bundle
import android.view.View
import online.jutter.shoplistnew.ui.Screens
import online.jutter.supersld.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowMainFragment : FlowFragment(ROUTER) {

    companion object {
        const val ROUTER = "main_router"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.ShopList)
                )
            )
        }
    }
}