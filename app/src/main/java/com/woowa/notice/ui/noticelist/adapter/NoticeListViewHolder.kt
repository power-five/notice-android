package com.woowa.notice.ui.noticelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.R
import com.woowa.notice.databinding.ItemNoticeBinding
import com.woowa.notice.uimodel.NoticeUIModel

class NoticeListViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_notice, parent, false),
) {
    private val binding = ItemNoticeBinding.bind(itemView)

    fun onBind(noticeItem: NoticeUIModel) {
        binding.notice = noticeItem
    }
}
