package com.example.foodtracker.presentation

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader(private val context: Context) {
    fun loadImage(url: String?, view: ImageView) {
        if (url == null) {
            return
        }

        Glide.with(context).load(url).into(view)
    }
}
