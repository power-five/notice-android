package com.woowa.notice.ui.noticewriting

import com.woowa.notice.uimodel.ExistArticleUIModel
import com.woowa.notice.uimodel.ImageUIModel

interface NoticeWritingContract {
    interface Presenter {
        fun submitPost(id: Long, title: String, description: String)
        fun addPhoto(url: String)
        fun removePhoto(image: ImageUIModel)
        fun loadPost(id: Long)
    }

    interface View {
        fun setViewContents(article: ExistArticleUIModel)
        fun updateImageView(images: List<ImageUIModel>)
        fun showImpossibleToAddImageToast()
    }
}
