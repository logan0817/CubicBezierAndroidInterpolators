package com.logan.cubicbezierandroidinterpolators.demo

import android.animation.Animator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.animation.Interpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.logan.cubicbezierandroidinterpolators.databinding.ActivityMainBinding
import com.logan.cubicbezierandroidinterpolators.interpolators.CubicBezierInterpolators


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()


    }


    private fun initView() {
        initContainer()
    }

    private fun initListener() {
        binding.btnRun.setOnClickListener { runAnim() }
        binding.btnReset.setOnClickListener { initContainer() }
    }

    private fun initContainer() {
        binding.container.removeAllViews()
        MockDatasUtils.list.forEachIndexed { index, type ->
            val textView = TextView(this, null)
            textView.text = "${type.name}"
            textView.textSize = 30F
            textView.setTextColor(Color.WHITE)
            textView.setBackgroundColor(Color.DKGRAY)
            val layoutParams =
                LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(0, 20, 0, 0)
            textView.layoutParams = layoutParams
            textView.setOnClickListener {

                createTranslationXAnimator(
                    CubicBezierInterpolators.createInterpolator(MockDatasUtils.list[index]),
                    textView,
                    (binding.container.width - textView.width).toFloat()
                ).start()
            }
            binding.container.addView(textView)
        }
    }

    private fun runAnim() {
        binding.container.children.forEachIndexed { index, view ->
            createTranslationXAnimator(
                CubicBezierInterpolators.createInterpolator(MockDatasUtils.list[index]),
                view,
                (binding.container.width - view.width).toFloat()
            ).start()
        }
    }

    val DURATION = 1000L

    private fun createTranslationXAnimator(
        interpolator: Interpolator,
        view: View,
        translationXValue: Float,
    ): Animator {
        val animator = ObjectAnimator.ofFloat(
            view, "translationX", 0f, translationXValue
        )
        animator.duration = DURATION
        animator.interpolator = interpolator
        return animator
    }
}