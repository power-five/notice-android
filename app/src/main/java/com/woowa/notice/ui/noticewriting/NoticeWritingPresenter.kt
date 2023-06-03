package com.woowa.notice.ui.noticewriting

import com.woowa.notice.domain.Article
import com.woowa.notice.domain.ExistArticle
import com.woowa.notice.domain.Writer
import com.woowa.notice.mapper.toDomain
import com.woowa.notice.mapper.toUIModel
import com.woowa.notice.repository.NoticeDetailRepository
import com.woowa.notice.repository.NoticeWritingRepository
import com.woowa.notice.uimodel.ImageUIModel

class NoticeWritingPresenter(
    private val view: NoticeWritingContract.View,
    private val noticeDetailRepository: NoticeDetailRepository,
    private val noticeWritingRepository: NoticeWritingRepository,
) : NoticeWritingContract.Presenter {
    private var isExistArticle: Boolean = false
    private lateinit var existArticle: ExistArticle
    private var images = emptyList<ImageUIModel>().toMutableList()

    override fun submitPost(id: Long, title: String, description: String) {
        if (isExistArticle) {
            noticeWritingRepository.updateNotice(
                id,
                ExistArticle(title, description, images.map { it.toDomain() }.toList()),
                onSuccess = { },
                onFailure = { throw IllegalStateException("게시물 처리 실패") },
            )
        } else {
            noticeWritingRepository.postNotice(
                Article(
                    title,
                    description,
                    Writer("로피", ""),
                    images.map { it.toDomain() }.toList(),
                ),
                onSuccess = { },
                onFailure = { throw IllegalStateException("게시물 처리 실패") },
            )
        }
    }

    override fun addPhoto(url: String) {
        if (images.size >= 10) {
            view.showImpossibleToAddImageToast()
            return
        }
        images.add(ImageUIModel(url))
        view.updateImageView(images.toList())
    }

    override fun removePhoto(image: ImageUIModel) {
        images.remove(image)
        view.updateImageView(images.toList())
    }

    override fun loadPost(id: Long) {
        noticeDetailRepository.getNotice(
            id,
            onSuccess = { notice ->
                isExistArticle = true
                existArticle = ExistArticle(
                    notice.title,
                    notice.description,
                    notice.images,
                )
                view.setViewContents(
                    existArticle.toUIModel(),
                )
                images = notice.images.map { it.toUIModel() }.toMutableList()
            },
            onFailure = { },
        )
    }
}
