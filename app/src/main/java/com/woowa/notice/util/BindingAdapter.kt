package com.woowa.notice.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.woowa.notice.R
import io.noties.markwon.Markwon

@BindingAdapter("ImagesBinding")
fun setNoticeImage(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .error(R.drawable.ic_launcher_foreground)
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(view)
}

@BindingAdapter("NoticeBinding")
fun setNoticeText(view: TextView, text: String?) {
    val markdown = Markwon.create(view.context)
    if (text != null) {
        markdown.setMarkdown(view, text)
    }
}
