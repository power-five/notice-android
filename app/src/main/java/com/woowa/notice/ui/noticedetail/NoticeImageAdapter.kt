package com.woowa.notice.ui.noticedetail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.ui.noticedetail.viewholder.NoticeImageViewHolder

class NoticeImageAdapter(private val images: List<String>) :
    RecyclerView.Adapter<NoticeImageViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): NoticeImageViewHolder {
        return NoticeImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NoticeImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
