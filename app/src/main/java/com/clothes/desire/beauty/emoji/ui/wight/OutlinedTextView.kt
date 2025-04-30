package com.clothes.desire.beauty.emoji.ui.wight

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet

class OutlinedTextView : AppCompatTextView {
    // 边框宽度保持2dp
    private val strokeWidth = 2
    // 新增渐变色常量
    private val gradientColors = intArrayOf(
        Color.parseColor("#FA8F1B"),
        Color.parseColor("#C86802")
    )
    // 修改后的边框颜色
    private val strokeColor = Color.parseColor("#FFF3E4")

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        val paint = paint
        // 绘制描边
        paint.apply {
            style = Paint.Style.STROKE
            strokeWidth = this@OutlinedTextView.strokeWidth.toFloat()
            color = strokeColor
        }
        super.onDraw(canvas)

        // 绘制渐变填充
        paint.apply {
            style = Paint.Style.FILL
            shader = LinearGradient(
                0f, 0f,
                width.toFloat(), 0f,
                gradientColors, null,
                Shader.TileMode.CLAMP
            )
        }
        super.onDraw(canvas)

        // 清理资源
        paint.shader = null
    }
}

