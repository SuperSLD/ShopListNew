package online.jutter.shoplistnew.ui.view

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_toolbar.view.*
import online.jutter.core.ui.ext.*
import online.jutter.shoplistnew.R
import online.jutter.supersld.extensions.addSystemTopPadding

class ToolbarView  : RelativeLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    init {
        View.inflate(context, R.layout.view_toolbar, this)
        TVtoolbar.addSystemTopPadding()
    }

    /**
     * Скрывать разделительную полоску при инициализации.
     */
    fun hideDivider() {
        vDivider.setVisible(false)
    }

    fun showColors(back: Int, text: Int, icon: Int) {
        TVtoolbar.setBackgroundColor(getColor(back))
        TVtvTitle.setTextColor(getColor(text))
        TVicClose.setColorFilter(getColor(icon), PorterDuff.Mode.SRC_IN)
    }

    fun init(
        title: Int?,
        back: (() -> Unit)? = null,
        longTitle: Boolean = false,
        action: ToolbarAction? = null
    ) {
        init(
            if (title != null) getString(title) else null,
            back,
            longTitle,
            action
        )
    }

    private fun toShort(string: String): String {
        return if (string.length < 20) string else string.take(20) + "..."
    }

    fun init(
        title: String? = null,
        back: (() -> Unit)? = null,
        longTitle: Boolean = false,
        action: ToolbarAction? = null
    ) {
        TVtoolbar.addSystemTopPadding()
        if (title != null)
            TVtvTitle.text = if (longTitle) toShort(title) else title

        if (back != null) {
            TVicClose.visibility = View.VISIBLE
            TVicClose.setOnClickListener { back() }
        } else {
            TVicClose.hide()
            TVicFirst.hide(View.INVISIBLE)
        }

        if (action != null) {
            with(TVicFirst) {
                visibility = VISIBLE
                setImageDrawable(getDrawable(action.iconId))
                setOnClickListener {
                    action.action()
                }
            }
        }
    }

    fun setTitle(titleId: Int, longTitle: Boolean = false) {
        setTitle(getString(titleId), longTitle)
    }

    fun setTitle(title: String, longTitle: Boolean = false) {
        TVtvTitle.text = if (longTitle) toShort(title) else title
    }

    data class ToolbarAction(
        val iconId: Int,
        val action: ()->Unit
    )
}