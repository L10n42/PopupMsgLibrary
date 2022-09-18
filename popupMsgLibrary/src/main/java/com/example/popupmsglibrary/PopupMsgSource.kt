package com.example.popupmsglibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.CountDownTimer
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import pl.droidsonroids.gif.GifImageView

class PopupMsgSource {
    private var globalYOffset: Int? = null
    private var globalXOffset: Int? = null

    private var globalPaddingLeft: Int = 27
    private var globalPaddingRight: Int = 27
    private var globalPaddingTop: Int = 20
    private var globalPaddingBottom: Int = 20

    private val minPadding: Int = 5

    @SuppressLint("InflateParams", "UseCompatLoadingForDrawables")
    fun makeMsg(
        context: Context,
        message: String,
        duration: Long,
        backgroundColor: Int,
        textColor: Int,
        gravity: Int,
        xOffset: Int?,
        yOffset: Int?,
        textSize: Float,
        elevation: Float,
        drawableLeft: Drawable?,
        drawableRight: Drawable?,
        drawableTop: Drawable?,
        drawableBottom: Drawable?,
        textAlignment: Int,
        strokeWidth: Int?,
        strokeColor: Int?,
        drawableLeftWidth: Int?,
        drawableLeftHeight: Int?,
        drawableRightWidth: Int?,
        drawableRightHeight: Int?,
        drawableTopWidth: Int?,
        drawableTopHeight: Int?,
        drawableBottomWidth: Int?,
        drawableBottomHeight: Int?,
        textPaddingLeft: Int?,
        textPaddingRight: Int?,
        textPaddingTop: Int?,
        textPaddingBottom: Int?,
        backgroundDrawable: Drawable?,
        cornerRadius: Float
    ) {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_msg_view, null)
        val popupWindow = PopupWindow(view, ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT)

        popupWindow.animationStyle = R.style.PopupAnim

        val background = view.findViewById<CardView>(R.id.background)
        val textView = view.findViewById<TextView>(R.id.text)
        val stroke = view.findViewById<ImageView>(R.id.stoke)
        val leftDrawable = view.findViewById<ImageView>(R.id.drawableLeft)
        val rightDrawable = view.findViewById<ImageView>(R.id.drawableRight)
        val topDrawable = view.findViewById<ImageView>(R.id.drawableTop)
        val bottomDrawable = view.findViewById<ImageView>(R.id.drawableBottom)
        val secondBackground = view.findViewById<ConstraintLayout>(R.id.secondBackground)

        if (xOffset == null && yOffset == null){
            globalYOffset = (getScreenHeight(context) / 2) - (getScreenHeight(context) / 5)
            globalXOffset = 0
        } else {
            globalYOffset = yOffset
            globalXOffset = xOffset
        }

        textView.text = message
        textView.setTextColor(textColor)
        textView.textSize = textSize
        textView.textAlignment = textAlignment

        background.setCardBackgroundColor(backgroundColor)
        background.radius = cornerRadius
        if (backgroundDrawable != null)
            secondBackground.background = backgroundDrawable

        popupWindow.elevation = elevation

        if (drawableLeft != null){
            leftDrawable.isVisible = true
            leftDrawable.setImageDrawable(drawableLeft)
        }

        if (drawableRight != null){
            rightDrawable.isVisible = true
            rightDrawable.setImageDrawable(drawableRight)
        }

        if (drawableTop != null){
            topDrawable.isVisible = true
            topDrawable.setImageDrawable(drawableTop)
        }

        if (drawableBottom != null) {
            bottomDrawable.isVisible = true
            bottomDrawable.setImageDrawable(drawableBottom)
        }

        if (strokeWidth != null && strokeColor != null){
            stroke.setImageDrawable(createStrokeDrawable(strokeWidth, strokeColor, cornerRadius))
        }

        if (drawableLeftWidth != null && drawableLeftHeight != null && drawableLeft != null){
            leftDrawable.updateLayoutParams<ConstraintLayout.LayoutParams> {
                this.width = drawableLeftWidth
                this.height = drawableLeftHeight
            }
        }

        if (drawableRightWidth != null && drawableRightHeight != null && drawableRight != null){
            rightDrawable.updateLayoutParams<ConstraintLayout.LayoutParams> {
                this.width = drawableRightWidth
                this.height = drawableRightHeight
            }
        }

        if (drawableTopWidth != null && drawableTopHeight != null && drawableTop != null){
            topDrawable.updateLayoutParams<ConstraintLayout.LayoutParams> {
                this.width = drawableTopWidth
                this.height = drawableTopHeight
            }
        }

        if (drawableBottomWidth != null && drawableBottomHeight != null && drawableBottom != null){
            bottomDrawable.updateLayoutParams<ConstraintLayout.LayoutParams> {
                this.width = drawableBottomWidth
                this.height = drawableBottomHeight
            }
        }

        if (textPaddingLeft == null && textPaddingRight == null
            && textPaddingTop == null && textPaddingBottom == null)
        {
            if (drawableLeft == null && drawableRight == null
                && drawableTop == null && drawableBottom == null)
            {
                textView.setPadding(globalPaddingLeft, globalPaddingTop, globalPaddingRight, globalPaddingBottom)
            } else {
                if (drawableLeft != null)
                    globalPaddingLeft = minPadding
                if (drawableRight != null)
                    globalPaddingRight = minPadding
                if (drawableTop != null)
                    globalPaddingTop = minPadding
                if (drawableBottom != null)
                    globalPaddingBottom = minPadding
                textView.setPadding(globalPaddingLeft, globalPaddingTop, globalPaddingRight, globalPaddingBottom)
            }
        } else
            textView.setPadding(textPaddingLeft!!, textPaddingTop!!, textPaddingRight!!, textPaddingBottom!!)

        popupWindow.showAtLocation(view, gravity,globalXOffset!!, globalYOffset!!)

        val timer = object: CountDownTimer(duration, 1000){
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                if (popupWindow.isShowing){
                    popupWindow.dismiss()
                }
            }
        }
        timer.start()
    }


    @SuppressLint("InflateParams")
    fun makeImg(
        context: Context,
        gifImgResource: Int?,
        drawable: Drawable?,
        type: Int,
        duration: Long,
        backgroundColor: Int,
        textColor: Int,
        gravity: Int,
        xOffset: Int?,
        yOffset: Int?,
        textSize: Float,
        elevation: Float,
        textAlignment: Int,
        strokeWidth: Int?,
        strokeColor: Int?,
        imgPaddingLeft: Int?,
        imgPaddingRight: Int?,
        imgPaddingTop: Int?,
        imgPaddingBottom: Int?,
        imgHeight: Int?,
        imgWidth: Int?,
        cropToPadding: Boolean?,
        bottomMsg: String?,
        topMsg: String?,
        backgroundDrawable: Drawable?,
        cornerRadius: Float
    ) {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_image_view, null)
        val popupWindow = PopupWindow(view, ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT)

        popupWindow.animationStyle = R.style.PopupAnim

        val background = view.findViewById<CardView>(R.id.imBackground)
        val stroke = view.findViewById<ImageView>(R.id.imStoke)
        val imGif = view.findViewById<GifImageView>(R.id.gifImageView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val tvTopMsg = view.findViewById<TextView>(R.id.topMsg)
        val tvBottomMsg = view.findViewById<TextView>(R.id.bottomMsg)
        val secondBackground = view.findViewById<ConstraintLayout>(R.id.imSecondBackground)

        if (xOffset == null && yOffset == null){
            globalYOffset = (getScreenHeight(context) / 2) - (getScreenHeight(context) / 5)
            globalXOffset = 0
        } else {
            globalYOffset = yOffset
            globalXOffset = xOffset
        }

        popupWindow.elevation = elevation

        background.setCardBackgroundColor(backgroundColor)
        background.radius = cornerRadius
        if (backgroundDrawable != null)
            secondBackground.background = backgroundDrawable

        if (bottomMsg != null){
            tvBottomMsg.isVisible = true
            tvBottomMsg.text = bottomMsg
            tvBottomMsg.setTextColor(textColor)
            tvBottomMsg.textSize = textSize
            tvBottomMsg.textAlignment = textAlignment
        }

        if (topMsg != null){
            tvTopMsg.isVisible = true
            tvTopMsg.text = topMsg
            tvTopMsg.setTextColor(textColor)
            tvTopMsg.textSize = textSize
            tvTopMsg.textAlignment = textAlignment
        }

        if (type == PopupMsg.TYPE_DRAWABLE && drawable != null){
            imageView.isVisible = true
            imageView.setImageDrawable(drawable)

            if (cropToPadding != null)
                imageView.cropToPadding = cropToPadding

            if (imgPaddingLeft != null && imgPaddingRight != null && imgPaddingTop != null && imgPaddingBottom != null){
                imageView.setPadding(imgPaddingLeft, imgPaddingTop, imgPaddingRight, imgPaddingBottom)
            } else
                imageView.setPadding(0, 0, 0, 0)

            if (imgWidth != null && imgHeight != null){
                imageView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    this.width = imgWidth
                    this.height = imgHeight
                }
            }

        } else if (type == PopupMsg.TYPE_GIF && gifImgResource != null){
            imGif.isVisible = true
            imGif.setImageResource(gifImgResource)

            if (cropToPadding != null)
                imGif.cropToPadding = cropToPadding

            if (imgPaddingLeft != null && imgPaddingRight != null && imgPaddingTop != null && imgPaddingBottom != null){
                imGif.setPadding(imgPaddingLeft, imgPaddingTop, imgPaddingRight, imgPaddingBottom)
            } else
                imGif.setPadding(0, 0, 0, 0)

            if (imgWidth != null && imgHeight != null){
                imGif.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    this.width = imgWidth
                    this.height = imgHeight
                }
            }
        }

        if (strokeWidth != null && strokeColor != null){
            stroke.setImageDrawable(createStrokeDrawable(strokeWidth, strokeColor, cornerRadius))
        }

        popupWindow.showAtLocation(view, gravity,globalXOffset!!, globalYOffset!!)

        val timer = object: CountDownTimer(duration, 1000){
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                if (popupWindow.isShowing){
                    popupWindow.dismiss()
                }
            }
        }
        timer.start()
    }


    private fun createStrokeDrawable(width: Int, color: Int, radius: Float): Drawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = radius
        shape.setStroke(width, color)

        return shape
    }

    private fun getScreenHeight(c: Context): Int {
        val displayMetrics = DisplayMetrics()
        val windowManager = c.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        return displayMetrics.heightPixels
    }
}