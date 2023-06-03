package com.woowa.notice.ui.noticelist.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.uimodel.NoticeListUIModel

class NoticeListAdapter(
    private var noticeItems: NoticeListUIModel,
    private val onItemClick: (Long) -> Unit,
) : RecyclerView.Adapter<NoticeListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeListViewHolder {
        return NoticeListViewHolder(parent) { position ->
            onItemClick(noticeItems.getNotice(position).noticeId)
        }
    }

    override fun getItemCount(): Int = noticeItems.size

    override fun onBindViewHolder(holder: NoticeListViewHolder, position: Int) {
        holder.onBind(noticeItems.getNotice(position))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateNoticeList(noticeItems: NoticeListUIModel) {
        this.noticeItems = noticeItems
        notifyDataSetChanged()
    }
}
