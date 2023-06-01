package com.woowa.notice.ui.noticewriting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woowa.notice.R
import com.woowa.notice.databinding.ItemImagePreviewBinding
import com.woowa.notice.uimodel.ImageUIModel

class NoticeWritingViewHolder(
    parent: ViewGroup,
    private val noticeWritingClickListener: NoticeWritingClickListener
): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_preview, parent, false)
) {
    private val binding = ItemImagePreviewBinding.bind(itemView)
    private lateinit var image: ImageUIModel

    init {
        binding.ivImageDeleteButton.setOnClickListener {
            noticeWritingClickListener.onClickRemove(image)
        }
    }

    fun bind(item: ImageUIModel) {
        image = item
        binding.image = item
    }
}