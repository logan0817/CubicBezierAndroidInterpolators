package com.logan.cubicbezierandroidinterpolators.interpolators

import android.view.animation.Interpolator
import androidx.core.view.animation.PathInterpolatorCompat

/**
 * 参考
 * android https://yisibl.github.io/cubic-bezier
 * 实现常见贝塞尔曲线动画效果
 * 枚举拿来方便直接使用
 *
 * *Reference
 * *Android https://yisibl.github.io/cubic-bezier
 * *Implementing common Bezier curve animation effects
 * *Enumeration for easy and direct use
 *
 */
object CubicBezierInterpolators {

    fun createInterpolator(type: Type): Interpolator {
        return type.create()
    }

    sealed class Type(
        val name: String? = null,
        private val controlX1: Float,
        private val controlY1: Float,
        private val controlX2: Float,
        private val controlY2: Float
    ) {
        object EASE : Type("EASE", 0.25f, 0.1f, 0.25f, 1f)

        object LINEAR : Type("LINEAR", 0f, 0f, 1f, 1f)

        object EASE_IN : Type("EASE_IN", 0.42f, 0f, 1f, 1f)

        object EASE_OUT : Type("EASE_OUT", 0f, 0f, 0.58f, 1f)

        object EASE_IN_OUT : Type("EASE_IN_OUT", 0.42f, 0f, 0.58f, 1f)

        object EASE_IN_SINE : Type("EASE_IN_SINE", 0.47f, 0f, 0.75f, 0.72f)

        object EASE_OUT_SINE : Type("EASE_OUT_SINE", 0.39f, 0.57f, 0.56f, 1f)

        object EASE_IN_OUT_SINE : Type("EASE_IN_OUT_SINE", 0.45f, 0.05f, 0.55f, 0.95f)

        object EASE_IN_QUAD : Type("EASE_IN_QUAD", 0.55f, 0.09f, 0.68f, 0.53f)

        object EASE_OUT_QUAD : Type("EASE_OUT_QUAD", 0.25f, 0.46f, 0.45f, 0.94f)

        object EASE_IN_OUT_QUAD : Type("EASE_IN_OUT_QUAD", 0.46f, 0.03f, 0.52f, 0.96f)

        object EASE_IN_CUBIC : Type("EASE_IN_CUBIC", 0.55f, 0.06f, 0.68f, 0.19f)

        object EASE_OUT_CUBIC : Type("EASE_OUT_CUBIC", 0.22f, 0.61f, 0.36f, 1f)

        object EASE_IN_OUT_CUBIC : Type("EASE_IN_OUT_CUBIC", 0.65f, 0.05f, 0.36f, 1f)

        object EASE_IN_QUART : Type("EASE_IN_QUART", 0.9f, 0.03f, 0.69f, 0.22f)

        object EASE_OUT_QUART : Type("EASE_OUT_QUART", 0.17f, 0.84f, 0.44f, 1f)

        object EASE_IN_OUT_QUART : Type("EASE_IN_OUT_QUART", 0.77f, 0f, 0.18f, 1f)

        object EASE_IN_QUINT : Type("EASE_IN_QUINT", 0.76f, 0.05f, 0.86f, 0.06f)

        object EASE_OUT_QUINT : Type("EASE_OUT_QUINT", 0.23f, 1f, 0.32f, 1f)

        object EASE_IN_OUT_QUINT : Type("EASE_IN_OUT_QUINT", 0.86f, 0f, 0.07f, 1f)

        object EASE_IN_EXPO : Type("EASE_IN_EXPO", 0.95f, 0.05f, 0.8f, 0.04f)

        object EASE_OUT_EXPO : Type("EASE_OUT_EXPO", 0.19f, 1f, 0.22f, 1f)

        object EASE_IN_CIRC : Type("EASE_IN_CIRC", 0.6f, 0.04f, 0.98f, 0.34f)

        object EASE_OUT_CIRC : Type("EASE_OUT_CIRC", 0.08f, 0.82f, 0.17f, 1f)

        object EASE_IN_OUT_CIRC : Type("EASE_IN_OUT_CIRC", 0.79f, 0.14f, 0.15f, 0.86f)

        object EASE_IN_BACK : Type("EASE_IN_BACK", 0.6f, -0.28f, 0.74f, 0.05f)

        object EASE_OUT_BACK : Type("EASE_OUT_BACK", 0.18f, 0.89f, 0.32f, 1.27f)

        object EASE_IN_OUT_BACK : Type("EASE_IN_OUT_BACK", 0.68f, -0.55f, 0.27f, 1.55f)

        fun create(): Interpolator {
            return PathInterpolatorCompat.create(controlX1, controlY1, controlX2, controlY2)
        }
    }
}