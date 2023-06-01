package com.woowa.notice.ui.noticedetail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.databinding.ItemNoticeImgBinding
import com.woowa.notice.uimodel.ImageUIModel

class NoticeImageViewHolder private constructor(
    private val binding: ItemNoticeImgBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(image: ImageUIModel) {
        binding.noticeImg = image.url
    }

    companion object {
        fun from(parent: ViewGroup): NoticeImageViewHolder {
            val binding =
                ItemNoticeImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return NoticeImageViewHolder(binding)
        }
    }
}
