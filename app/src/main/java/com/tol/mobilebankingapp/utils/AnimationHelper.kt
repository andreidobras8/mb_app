package com.tol.mobilebankingapp.utils

import android.animation.AnimatorInflater
import android.content.Context
import android.os.Handler
import android.widget.Button
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import com.tol.mobilebankingapp.R

class AnimationHelper {

    companion object {
        fun startAnimation(ctx: Context, btn: Button, isCardFlipped: Boolean) : Boolean {
            val animateInflater = AnimatorInflater.loadAnimator(ctx, R.animator.flip)
            animateInflater.setTarget(btn)
            animateInflater.doOnStart {
                Handler().postDelayed({
                    btn.text = ""
                }, 700)
            }
            animateInflater.doOnEnd {
                btn.text = if (!isCardFlipped) "750.50 RON" else "SHOW BALANCE"
            }
            animateInflater.start()
            return !isCardFlipped
        }
    }
}