package com.woowa.notice.ui.noticewriting

import com.woowa.notice.mapper.toUIModel
import com.woowa.notice.repository.NoticeDetailRepository
import com.woowa.notice.repository.NoticeWritingRepository

class NoticeWritingPresenter(
    private val view: NoticeWritingContract.View,
    private val noticeDetailRepository: NoticeDetailRepository,
    private val noticeWritingRepository: NoticeWritingRepository
): NoticeWritingContract.Presenter {
    override fun submitPost() {
    }

    override fun submitPhoto() {
    }

    override fun loadPost(id: Long) {
        noticeDetailRepository.getNotice(
            id,
            onSuccess = { notice ->
                view.setViewContents(notice.toUIModel())
            },
            onFailure = { throw IllegalArgumentException("상세보기를 실패했습니다.") },
        )
    }
}