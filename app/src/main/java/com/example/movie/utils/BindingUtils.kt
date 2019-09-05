package com.example.movie.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movie.base.RecyclerBindingAdapter
import com.example.movie.main.films.data.model.PopularMovie

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
const val IMG_URL_PREFIX = "https://image.tmdb.org/t/p/w500"

object BindingUtils {

    @JvmStatic
    @BindingAdapter("populars")
    fun RecyclerView.bindItems(items: LiveData<List<PopularMovie>>) {
        items.value ?: return
        val adapter = adapter as RecyclerBindingAdapter<PopularMovie>
        adapter.setItems(items.value)
    }

    @JvmStatic
    @BindingAdapter("loadImg")
    fun loadImg(image: ImageView, url: String?) {
        url ?: return

        val circularProgressDrawable = CircularProgressDrawable(image.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(image.context)
            .load(IMG_URL_PREFIX + url)
            .fitCenter()
            .transform(RoundedCorners(8))
            .placeholder(circularProgressDrawable)
            .into(image)
    }

}