package com.woowa.notice.ui.noticewriting

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.uimodel.ImageUIModel

class NoticeWritingAdapter(
    private var images: List<ImageUIModel>,
    private val noticeWritingClickListener: NoticeWritingClickListener
): RecyclerView.Adapter<NoticeWritingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeWritingViewHolder {
        return NoticeWritingViewHolder(parent, noticeWritingClickListener)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: NoticeWritingViewHolder, position: Int) {
        holder.bind(images[position])
    }

    fun update(updatedImages: List<ImageUIModel>) {
        images = updatedImages
        notifyDataSetChanged()
    }
}