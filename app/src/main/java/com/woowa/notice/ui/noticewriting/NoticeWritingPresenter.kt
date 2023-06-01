package com.woowa.notice.ui.noticewriting

import com.woowa.notice.domain.Article
import com.woowa.notice.domain.ExistArticle
import com.woowa.notice.domain.Writer
import com.woowa.notice.mapper.toUIModel
import com.woowa.notice.repository.NoticeDetailRepository
import com.woowa.notice.repository.NoticeWritingRepository

class NoticeWritingPresenter(
    private val view: NoticeWritingContract.View,
    private val noticeDetailRepository: NoticeDetailRepository,
    private val noticeWritingRepository: NoticeWritingRepository
) : NoticeWritingContract.Presenter {
    private var isExistArticle: Boolean = false
    private lateinit var existArticle: ExistArticle

    override fun submitPost(id: Long, title: String, description: String) {
        if (isExistArticle) {
            noticeWritingRepository.updateNotice(
                id,
                ExistArticle(title, description, existArticle.images),
                onSuccess = { },
                onFailure = {
                    throw IllegalStateException("게시물 처리 실패")
                }
            )
        } else {
            noticeWritingRepository.postNotice(
                Article(title, description, Writer("로피", ""), emptyList()),
                onSuccess = { },
                onFailure = {
                    throw IllegalStateException("게시물 처리 실패")
                }
            )
        }
    }

    override fun submitPhoto() {
    }

    override fun loadPost(id: Long) {
        noticeDetailRepository.getNotice(
            id,
            onSuccess = { notice ->
                isExistArticle = true
                existArticle = ExistArticle(
                    notice.title,
                    notice.description,
                    notice.images
                )
                view.setViewContents(
                    existArticle.toUIModel()
                )
            },
            onFailure = {
            },
        )
    }
}