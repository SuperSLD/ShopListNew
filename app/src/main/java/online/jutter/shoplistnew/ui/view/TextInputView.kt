package online.jutter.shoplistnew.ui.view

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_text_input.view.*
import online.jutter.core.ui.ext.getString
import online.jutter.core.ui.ext.setVisible
import online.jutter.shoplistnew.R

/**
 * Элемент для ввода текста с красивой рамкой.
 */
class TextInputView  : RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    private var mInputTypeKey = TEXT
    private val mMinLines = 1

    companion object {
        const val TEXT = 1
        const val TEXT_MULTILINE = 2
        const val INTEGER = 3
        const val TEXT_PASSWORD = 4

        private val inputTypeMap = hashMapOf(
            TEXT to InputType.TYPE_CLASS_TEXT,
            TEXT_MULTILINE to (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE),
            INTEGER to (InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL),
            TEXT_PASSWORD to (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        )
    }

    init {
        View.inflate(context, R.layout.view_text_input, this)
        setOnClickListener {
            etInputLine.requestFocus()
        }
        with(etInputLine) {
            inputType = findInputType()
            hint = ""
        }
    }

    fun setInputType(type: Int) {
        mInputTypeKey = type
        etInputLine.inputType = findInputType()
    }

    fun setHint(id: Int) {
        setHint(getString(id))
    }

    fun setHint(string: String?) {
        tvHint.text = string
        tvHint.setVisible(string != null)
    }

    fun setMandatory(show: Boolean) {
        tvMand.setVisible(show)
    }

    fun setText(resId: Int) {
        etInputLine.setText(resId)
    }

    fun setText(text: String) {
        etInputLine.setText(text)
    }

    fun getText() = etInputLine.text.toString()

    private fun findInputType() = inputTypeMap[mInputTypeKey] ?:
     throw IllegalArgumentException("invalid TextInputLine inputType, $mInputTypeKey not found")
}