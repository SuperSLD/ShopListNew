package online.jutter.shoplistnew.ui

import android.os.Bundle
import android.view.View
import online.jutter.supersld.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowGlobalFragment : FlowFragment(router = ROUTER) {
    companion object {
        const val ROUTER = "global_router"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.Splash)
                )
            )
        }
    }
}