package com.example.foodtracker.presentation

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader {
    fun loadImage(context: Context?, url: String?, view: ImageView){
        Glide.with(context!!).load(url).into(view)
    }
}