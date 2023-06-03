package com.woowa.notice.repository

import com.woowa.notice.domain.Article
import com.woowa.notice.domain.ExistArticle
import com.woowa.notice.dto.ArticleDTO
import com.woowa.notice.dto.ExistArticleDTO
import com.woowa.notice.dto.ImageDTO
import com.woowa.notice.service.RetrofitClient
import com.woowa.notice.util.createResponseCallback

class NoticeWritingRepositoryImpl : NoticeWritingRepository {

    override fun postNotice(
        article: Article,
        onSuccess: (Unit) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        RetrofitClient.noticeService
            .postNotice(
                ArticleDTO(
                    article.title,
                    article.description,
                    1,
                    article.images.map { ImageDTO(it.url) },
                ),
            )
            .enqueue(
                createResponseCallback(onSuccess, onFailure),
            )
    }

    override fun updateNotice(
        id: Long,
        existArticle: ExistArticle,
        onSuccess: (Unit) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        RetrofitClient.noticeService
            .putNotice(
                id,
                ExistArticleDTO(
                    existArticle.title,
                    existArticle.description,
                    existArticle.images.map { ImageDTO(it.url) },
                ),
            )
            .enqueue(
                createResponseCallback(onSuccess, onFailure),
            )
    }
}
