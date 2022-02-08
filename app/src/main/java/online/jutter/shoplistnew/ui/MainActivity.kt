package online.jutter.shoplistnew.ui

import androidx.fragment.app.Fragment
import online.jutter.shoplistnew.R
import online.jutter.supersld.ActivityBase

class MainActivity : ActivityBase() {
    override fun getStatusAndNavigationColor(): Pair<Int, Int> {
        return Pair(R.color.colorStatusBar, R.color.colorStatusBar)
    }

    override fun themeIsDay(): Boolean {
        return true
    }

    override fun getStartFragment(): Fragment {
        return Screens.FlowGlobal.fragment
    }
}