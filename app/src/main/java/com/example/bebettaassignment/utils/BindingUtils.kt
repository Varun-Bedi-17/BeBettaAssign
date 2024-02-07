package com.example.bebettaassignment.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter

object BindingUtils {
    @BindingAdapter("sourceImage")
    @JvmStatic
    fun setSourceImage(
        imageView: ImageView,
        src: Int,
    ) {
        imageView.setImageResource(src)
    }

    @BindingAdapter("textViewColor")
    @JvmStatic
    fun setTextColor(
        textView: TextView,
        src: Int
    ) {
        textView.setTextColor(src)
    }

    @BindingAdapter("clBackground")
    @JvmStatic
    fun setBackground(
        constraintLayout: ConstraintLayout,
        src: Int,
    ) {
        constraintLayout.setBackgroundResource(src)
    }
}
