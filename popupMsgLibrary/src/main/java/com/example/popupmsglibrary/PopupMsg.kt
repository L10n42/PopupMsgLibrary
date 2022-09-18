package com.example.popupmsglibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View

class PopupMsg {
    companion object{
        /** Default constants */
        private const val DEFAULT_TEXT_SIZE: Float = 14f
        private const val DEFAULT_ELEVATION: Float = 10f
        private const val DEFAULT_CORNER_RADIUS: Float = 33f

        /** Type constants */
        const val TYPE_DRAWABLE = 0
        const val TYPE_GIF = 1

        /** Duration constants */
        const val DURATION_SHORT: Long = 2000
        const val DURATION_LONG: Long = 3500
    }

    data class TextBuilder(
        val context: Context,
        val message: String,
        var duration: Long = DURATION_SHORT,
        var backgroundColor: Int = Color.WHITE,
        var textColor: Int = Color.BLACK,
        var gravity: Int = Gravity.CENTER,
        var xOffset: Int? = null,
        var yOffset: Int? = null,
        var textSize: Float = DEFAULT_TEXT_SIZE,
        var elevation: Float = DEFAULT_ELEVATION,
        var drawableLeft: Drawable? = null,
        var drawableRight: Drawable? = null,
        var drawableTop: Drawable? = null,
        var drawableBottom: Drawable? = null,
        var textAlignment: Int = View.TEXT_ALIGNMENT_CENTER,
        var strokeWidth: Int? = null,
        var strokeColor: Int? = null,
        var drawableLeftWidth: Int? = null,
        var drawableLeftHeight: Int? = null,
        var drawableRightWidth: Int? = null,
        var drawableRightHeight: Int? = null,
        var drawableTopWidth: Int? = null,
        var drawableTopHeight: Int? = null,
        var drawableBottomWidth: Int? = null,
        var drawableBottomHeight: Int? = null,
        var textPaddingLeft: Int? = null,
        var textPaddingRight: Int? = null,
        var textPaddingTop: Int? = null,
        var textPaddingBottom: Int? = null,
        var backgroundDrawable: Drawable? = null,
        var cornerRadius: Float = DEFAULT_CORNER_RADIUS
    ) {

        private val res = this.context.resources

        fun setCornerRadius(radius: Float) = apply { this.cornerRadius = radius }
        @SuppressLint("UseCompatLoadingForDrawables")
        fun setBackgroundDrawResource(resId: Int) = apply { this.backgroundDrawable = res.getDrawable(resId) }
        fun setBackgroundDrawable(drawable: Drawable?) = apply { this.backgroundDrawable = drawable }
        fun setDuration(durationInMillis: Long) = apply { this.duration = durationInMillis }
        fun setBackgroundColor(color: Int) = apply { this.backgroundColor = color }
        fun setBackgroundResourceColor(resId: Int) = apply { this.backgroundColor = res.getColor(resId) }
        fun setTextColor(color: Int) = apply { this.textColor = color }
        fun setTextResourceColor(resId: Int) = apply { this.textColor = res.getColor(resId) }
        fun setGravity(gravity: Int, xOffset: Int, yOffset: Int) = apply {
            this.gravity = gravity
            this.xOffset = xOffset
            this.yOffset = yOffset
        }
        fun setTextSize(size: Float) = apply { this.textSize = size }
        fun setElevation(elevation: Float) = apply { this.elevation = elevation }
        fun setDrawableLeft(drawable: Drawable) = apply { this.drawableLeft = drawable }
        fun setDrawableRight(drawable: Drawable) = apply { this.drawableRight = drawable }
        fun setDrawableTop(drawable: Drawable) = apply { this.drawableTop = drawable }
        fun setDrawableBottom(drawable: Drawable) = apply { this.drawableBottom = drawable }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun setDrawableLeftResource(resId: Int) = apply { this.drawableLeft = res.getDrawable(resId) }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun setDrawableRightResource(resId: Int) = apply { this.drawableRight = res.getDrawable(resId) }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun setDrawableTopResource(resId: Int) = apply { this.drawableTop = res.getDrawable(resId) }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun setDrawableBottomResource(resId: Int) = apply { this.drawableBottom = res.getDrawable(resId) }

        fun setTextAlignment(alignment: Int) = apply { this.textAlignment = alignment }
        fun setStroke(width: Int, color: Int) = apply {
            this.strokeWidth = width
            this.strokeColor = color
        }
        fun setDrawableLeftSize(width: Int, height: Int) = apply {
            this.drawableLeftWidth = width
            this.drawableLeftHeight = height
        }
        fun setDrawableRightSize(width: Int, height: Int) = apply {
            this.drawableRightWidth = width
            this.drawableRightHeight = height
        }
        fun setDrawableTopSize(width: Int, height: Int) = apply {
            this.drawableTopWidth = width
            this.drawableTopHeight = height
        }
        fun setDrawableBottomSize(width: Int, height: Int) = apply {
            this.drawableBottomWidth = width
            this.drawableBottomHeight = height
        }
        fun setTextPadding(left: Int, right: Int, top: Int, bottom: Int) = apply {
            this.textPaddingLeft = left
            this.textPaddingRight = right
            this.textPaddingTop = top
            this.textPaddingBottom = bottom
        }

        fun show() {
            val window = PopupMsgSource()
            window.makeMsg(
                context,
                message,
                duration,
                backgroundColor,
                textColor,
                gravity,
                xOffset,
                yOffset,
                textSize,
                elevation,
                drawableLeft,
                drawableRight,
                drawableTop,
                drawableBottom,
                textAlignment,
                strokeWidth,
                strokeColor,
                drawableLeftWidth,
                drawableLeftHeight,
                drawableRightWidth,
                drawableRightHeight,
                drawableTopWidth,
                drawableTopHeight,
                drawableBottomWidth,
                drawableBottomHeight,
                textPaddingLeft,
                textPaddingRight,
                textPaddingTop,
                textPaddingBottom,
                backgroundDrawable,
                cornerRadius
            )
        }
    }


    data class ImgBuilder (
        val context: Context,
        var gifImgResource: Int? = null,
        var drawable: Drawable? = null,
        var type: Int = TYPE_DRAWABLE,
        var duration: Long = DURATION_SHORT,
        var backgroundColor: Int = Color.WHITE,
        var textColor: Int = Color.BLACK,
        var gravity: Int = Gravity.CENTER,
        var xOffset: Int? = null,
        var yOffset: Int? = null,
        var textSize: Float = DEFAULT_TEXT_SIZE,
        var elevation: Float = DEFAULT_ELEVATION,
        var textAlignment: Int = View.TEXT_ALIGNMENT_CENTER,
        var strokeWidth: Int? = null,
        var strokeColor: Int? = null,
        var imgPaddingLeft: Int? = null,
        var imgPaddingRight: Int? = null,
        var imgPaddingTop: Int? = null,
        var imgPaddingBottom: Int? = null,
        var imgWidth: Int? = null,
        var imgHeight: Int? = null,
        var cropToPadding: Boolean? = null,
        var bottomMsg: String? = null,
        var topMsg: String? = null,
        var backgroundDrawable: Drawable? = null,
        var cornerRadius: Float = DEFAULT_CORNER_RADIUS

    ){
        private val res = this.context.resources

        fun setCornerRadius(radius: Float) = apply { this.cornerRadius = radius }
        @SuppressLint("UseCompatLoadingForDrawables")
        fun setBackgroundDrawResource(resId: Int) = apply { this.backgroundDrawable = res.getDrawable(resId) }
        fun setBackgroundDrawable(drawable: Drawable?) = apply { this.backgroundDrawable = drawable }
        fun setGifImgResource(resId: Int) = apply { this.gifImgResource = resId }
        fun setDrawable(drawable: Drawable) = apply { this.drawable = drawable }
        fun setDuration(durationInMillis: Long) = apply { this.duration = durationInMillis }
        fun setType(type: Int) = apply { this.type = type }
        fun setBackgroundColor(color: Int) = apply { this.backgroundColor = color }
        fun setBackgroundResourceColor(resId: Int) = apply { this.backgroundColor = res.getColor(resId) }
        fun setTextColor(color: Int) = apply { this.textColor = color }
        fun setTextResourceColor(resId: Int) = apply { this.textColor = res.getColor(resId) }

        fun setGravity(gravity: Int, xOffset: Int, yOffset: Int) = apply {
            this.gravity = gravity
            this.xOffset = xOffset
            this.yOffset = yOffset
        }

        fun setTextSize(size: Float) = apply { this.textSize = size }
        fun setElevation(elevation: Float) = apply { this.elevation = elevation }
        fun setTextAlignment(alignment: Int) = apply { this.textAlignment = alignment }

        fun setStroke(width: Int, color: Int) = apply {
            this.strokeWidth = width
            this.strokeColor = color
        }

        fun setImgPadding(left: Int, right: Int, top: Int, bottom: Int) = apply {
            this.imgPaddingLeft = left
            this.imgPaddingRight = right
            this.imgPaddingTop = top
            this.imgPaddingBottom = bottom
        }

        fun setImgSize(width: Int, height: Int) = apply {
            this.imgHeight = height
            this.imgWidth = width
        }

        fun setCropToPadding(cropToPadding: Boolean) = apply {
            this.cropToPadding = cropToPadding
        }

        fun setBottomMsg(msg: String) = apply { this.bottomMsg = msg }
        fun setTopMsg(msg: String) = apply { this.topMsg = msg }

        fun show() {
            val window = PopupMsgSource()
            window.makeImg(
                context,
                gifImgResource,
                drawable,
                type,
                duration,
                backgroundColor,
                textColor,
                gravity,
                xOffset,
                yOffset,
                textSize,
                elevation,
                textAlignment,
                strokeWidth,
                strokeColor,
                imgPaddingLeft,
                imgPaddingRight,
                imgPaddingTop,
                imgPaddingBottom,
                imgHeight,
                imgWidth,
                cropToPadding,
                bottomMsg,
                topMsg,
                backgroundDrawable,
                cornerRadius
            )
        }
    }

}