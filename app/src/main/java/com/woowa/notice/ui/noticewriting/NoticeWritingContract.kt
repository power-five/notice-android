package com.woowa.notice.ui.noticewriting

import com.woowa.notice.uimodel.ExistArticleUIModel

interface NoticeWritingContract {
    interface Presenter {
        fun submitPost(id: Long, title: String, description: String)
        fun submitPhoto()
        fun loadPost(id: Long)
    }

    interface View {
        fun setViewContents(article: ExistArticleUIModel)
    }
}