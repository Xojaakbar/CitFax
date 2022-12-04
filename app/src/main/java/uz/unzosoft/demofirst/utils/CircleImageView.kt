package uz.unzosoft.demofirst.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View.MeasureSpec
import androidx.appcompat.widget.AppCompatImageView


/**
 * Created by Abdurashidov Shahzod on 14/10/22 15:11.
 * company QQBank
 * shahzod9933@gmail.com
 */
class CircleImageView : AppCompatImageView {
    private var borderWidth = 4
    private var viewWidth = 0
    private var viewHeight = 0
    private var image: Bitmap? = null
    private var paint: Paint? = null
    private var paintBorder: Paint? = null
    private var shader: BitmapShader? = null

    constructor(context: Context?) : super(context!!) {
        setup()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        setup()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!,
        attrs,
        defStyle
    ) {
        setup()
    }

    private fun setup() {
        paint = Paint()
        paint!!.isAntiAlias = true
        paintBorder = Paint()
        setBorderColor(Color.WHITE)
        paintBorder!!.isAntiAlias = true
        this.setLayerType(LAYER_TYPE_SOFTWARE, paintBorder)
        paintBorder!!.setShadowLayer(4.0f, 0.0f, 2.0f, Color.WHITE)
    }

    fun setBorderWidth(borderWidth: Int) {
        this.borderWidth = borderWidth
        this.invalidate()
    }

    fun setBorderColor(borderColor: Int) {
        paintBorder?.color = borderColor
        this.invalidate()
    }

    private fun loadBitmap() {
        val bitmapDrawable = this.drawable as BitmapDrawable?
        if (bitmapDrawable != null) image = bitmapDrawable.bitmap
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        loadBitmap()
        if (image != null) {
            shader = BitmapShader(
                Bitmap.createScaledBitmap(
                    image!!,
                    width,
                    height,
                    false
                ), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
            )
            paint!!.shader = shader
            val circleCenter = viewWidth / 2
            paintBorder?.let {
                canvas.drawCircle(
                    (circleCenter + borderWidth).toFloat(),
                    (circleCenter + borderWidth).toFloat(),
                    circleCenter + borderWidth - 4.0f,
                    it
                )
            }
            paint?.let {
                canvas.drawCircle(
                    (circleCenter + borderWidth).toFloat(),
                    (circleCenter + borderWidth).toFloat(),
                    circleCenter - 4.0f,
                    it
                )
            }
        }
    }

    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = measureWidth(widthMeasureSpec)
        val height = measureHeight(heightMeasureSpec, widthMeasureSpec)
        viewWidth = width - borderWidth * 2
        viewHeight = height - borderWidth * 2
        setMeasuredDimension(width, height)
    }

    private fun measureWidth(measureSpec: Int): Int {
        var result = 0
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        result = if (specMode == MeasureSpec.EXACTLY) {
            specSize
        } else {
            // Measure the text
            viewWidth
        }
        return result
    }

    private fun measureHeight(measureSpecHeight: Int, measureSpecWidth: Int): Int {
        var result = 0
        val specMode = MeasureSpec.getMode(measureSpecHeight)
        val specSize = MeasureSpec.getSize(measureSpecHeight)
        result = if (specMode == MeasureSpec.EXACTLY) {
            specSize
        } else {
            viewHeight
        }
        return result + 2
    }
}