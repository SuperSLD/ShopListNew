package online.jutter.shoplistnew.ui.view

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Vibrator
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_counter.view.*
import online.jutter.core.ui.ext.getColor
import online.jutter.core.ui.ext.getDrawable
import online.jutter.core.ui.ext.shortVibration
import online.jutter.shoplistnew.R

class CounterView  : RelativeLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    private var mCount = 1
    private var mMaxCount = 0
    private var mAccentShape: Int = R.drawable.shape_blue_solid
    private var mCountListener: ((Int) -> Unit)? = null
    private var mRemoveListener: (() -> Unit)? = null

    private var mVibrator: Vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    init {
        View.inflate(context, R.layout.view_counter, this)
        btnAdd.setOnClickListener {
            mCount++
            updateCount()
        }
        btnRemove.setOnClickListener {
            mCount--
            updateCount()
        }
    }

    fun setAccentColor(color: String) {
        mAccentShape = Color.parseColor(color)
    }

    fun setAccentColor(colorId: Int) {
        mAccentShape = getColor(colorId)
    }

    fun setMaxCount(maxCount: Int) {
        mMaxCount = maxCount
    }

    fun setCount(count: Int, maxCount: Int = 0) {
        mMaxCount = maxCount
        mCount = count
        updateCount(false)
    }

    private fun updateCount(callCallback: Boolean = true) {
        tvCounter.text = mCount.toString()
        if (mMaxCount in 1..mCount) {
            btnAdd.disable()
        } else {
            btnAdd.enable()
        }
        if (mCount == 0) {
            if (callCallback) mRemoveListener?.invoke()
            btnRemove.disable()
        } else {
            btnRemove.enable()
        }
        btnRemove.setImageDrawable(getDrawable(if (mCount == 1) R.drawable.ic_delete else R.drawable.ic_remove))
        if (callCallback) mVibrator.shortVibration()
        if (callCallback && mCount > 0) mCountListener?.invoke(mCount)
    }

    private fun ImageButton.disable() {
        setBackgroundResource(R.drawable.shape_grey_solid)
        setColorFilter(getColor(R.color.colorTextSecondary), PorterDuff.Mode.SRC_IN)
        isEnabled = false
    }

    private fun ImageButton.enable() {
        setBackgroundResource(mAccentShape)
        setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN)
        isEnabled = true
    }

    fun onCountUpdate(updateListener: (Int) -> Unit) {
        mCountListener = updateListener
    }

    fun onRemove(updateListener: () -> Unit) {
        mRemoveListener = updateListener
    }
}