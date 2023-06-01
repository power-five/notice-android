package com.woowa.notice.ui.noticewriting

interface NoticeWritingContract {
    interface Presenter {
        fun submitPost()
        fun submitPhoto()
        fun loadPost()
    }

    interface View {
        fun initView()
    }
}