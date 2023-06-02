package com.woowa.notice.repository

import com.woowa.notice.domain.Article
import com.woowa.notice.domain.ExistArticle

interface NoticeWritingRepository {
    fun postNotice(article: Article, onSuccess: (Unit) -> Unit, onFailure: (Exception) -> Unit)
    fun updateNotice(
        id: Long,
        existArticle: ExistArticle,
        onSuccess: (Unit) -> Unit,
        onFailure: (Exception) -> Unit
    )
}