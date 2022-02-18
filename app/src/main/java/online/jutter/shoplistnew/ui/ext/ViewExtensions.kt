package online.jutter.core.ui.ext

import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun View.getColor(id: Int) = ContextCompat.getColor(context, id)
fun View.getDrawable(id: Int) = ContextCompat.getDrawable(context, id)
fun View.getString(id: Int) = context.getString(id)
fun View.setBackgroundGradient(color1: String, color2: String) {
    setBackgroundGradient(Color.parseColor(color1), Color.parseColor(color2))
}
fun View.setBackgroundGradient(color1: Int, color2: Int) {
    val gradientDrawable = GradientDrawable(
        GradientDrawable.Orientation.TOP_BOTTOM,
        intArrayOf(color1, color2)
    )
    gradientDrawable.cornerRadius = 0f

    this.background = gradientDrawable
}

fun Fragment.getColor(id: Int) = ContextCompat.getColor(requireContext(), id)
fun Fragment.getDrawable(id: Int) = ContextCompat.getDrawable(requireContext(), id)
fun Fragment.getString(id: Int) = requireContext().getString(id)


private fun View.smoothHide(animationDuration: Long = 1000L, onAnimationEnd: ((View)->Unit)? = null) {
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            this@smoothHide.alpha = 1F - interpolatedTime
            if (interpolatedTime == 1F) {
                if (onAnimationEnd == null) {
                    visibility = View.GONE
                } else {
                    onAnimationEnd(this@smoothHide)
                }
            }
        }

        override fun willChangeBounds(): Boolean {
            return false
        }
    }
    a.duration = animationDuration
    this.startAnimation(a)
}

fun View.smoothShow(animationDuration: Long = 1000L, onAnimationEnd: ((View)->Unit)? = null) {
    visibility = View.VISIBLE
    alpha = 0F
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            this@smoothShow.alpha = interpolatedTime
            if (interpolatedTime == 1F) onAnimationEnd?.invoke(this@smoothShow )
        }

        override fun willChangeBounds(): Boolean {
            return false
        }
    }
    a.duration = animationDuration
    this.startAnimation(a)
}

fun View.expand(animationDuration: Long? = null, vertical: Boolean = true, onAnimationEnd: ((View)->Unit)? = null) {
    val matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(
        if (vertical) (this.parent as View).width else (this.parent as View).height,
        View.MeasureSpec.EXACTLY
    )
    val wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    if (vertical) {
        this.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
    } else {
        this.measure(wrapContentMeasureSpec, matchParentMeasureSpec)
    }
    val targetHeight = this.measuredHeight
    val targetWidth = this.measuredWidth

    if (vertical) {
        this.layoutParams.height = 1
        this.layoutParams.width = ActionBar.LayoutParams.WRAP_CONTENT
    } else {
        this.layoutParams.height = ActionBar.LayoutParams.WRAP_CONTENT
        this.layoutParams.width = 1
    }
    this.visibility = View.VISIBLE
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            if (vertical) {
                this@expand.layoutParams.height =
                    if (interpolatedTime == 1f) ActionBar.LayoutParams.WRAP_CONTENT else (targetHeight * interpolatedTime).toInt()
            } else {
                this@expand.layoutParams.width =
                    if (interpolatedTime == 1f) ActionBar.LayoutParams.WRAP_CONTENT else (targetWidth * interpolatedTime).toInt()
            }
            if (interpolatedTime == 1F) onAnimationEnd?.invoke(this@expand)
            this@expand.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    // Expansion speed of 1dp/ms
    a.duration = animationDuration ?: (targetHeight / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(a)
}

fun View.collapse(animationDuration: Long? = null, vertical: Boolean = true) {
    val initialHeight = this.measuredHeight
    val initialWidth = this.measuredWidth
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            if (interpolatedTime == 1f) {
                this@collapse.visibility = View.GONE
            } else {
                if (vertical) {
                    this@collapse.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                } else {
                    this@collapse.layoutParams.width = initialWidth - (initialWidth * interpolatedTime).toInt()
                }
                this@collapse.requestLayout()
            }
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    // Collapse speed of 1dp/ms
    a.duration = animationDuration ?: (initialHeight / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(a)
}

fun View.hide(vType: Int = View.GONE) {
    this.visibility = vType
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.setVisible(show: Boolean, vType: Int = View.GONE) {
    visibility = if (show) View.VISIBLE else vType
}

fun EditText.addTextChangeListener(listener: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            listener(s.toString())
        }
        override fun afterTextChanged(s: Editable?) {}
    })
}

fun Vibrator.shortVibration() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrate(100)
    }
}
