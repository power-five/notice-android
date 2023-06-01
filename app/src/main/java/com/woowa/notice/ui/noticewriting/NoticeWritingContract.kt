package com.woowa.notice.ui.noticewriting

import com.woowa.notice.uimodel.NoticeUIModel

interface NoticeWritingContract {
    interface Presenter {
        fun submitPost()
        fun submitPhoto()
        fun loadPost(id: Long)
    }

    interface View {
        fun setViewContents(notice: NoticeUIModel)
    }
}