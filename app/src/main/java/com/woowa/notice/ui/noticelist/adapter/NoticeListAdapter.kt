package com.woowa.notice.ui.noticelist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.uimodel.NoticeUIModel

class NoticeListAdapter(
    private val noticeItems: List<NoticeUIModel>,
    private val onItemClick: (Long) -> Unit,
) : RecyclerView.Adapter<NoticeListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeListViewHolder {
        return NoticeListViewHolder(parent) { position ->
            onItemClick(noticeItems[position].noticeId)
        }
    }

    override fun getItemCount(): Int = noticeItems.size

    override fun onBindViewHolder(holder: NoticeListViewHolder, position: Int) {
        holder.onBind(noticeItems[position])
    }
}
