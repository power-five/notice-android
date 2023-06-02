package com.woowa.notice.mapper

import com.woowa.notice.domain.Article
import com.woowa.notice.domain.ExistArticle
import com.woowa.notice.uimodel.ArticleUIModel
import com.woowa.notice.uimodel.ExistArticleUIModel

fun Article.toUIModel(): ArticleUIModel =
    ArticleUIModel(title, description, writer.toUIModel(), images.map { it.toUIModel() })

fun ArticleUIModel.toDomain(): Article =
    Article(title, description, writer.toDomain(), images.map { it.toDomain() })

fun ExistArticle.toUIModel(): ExistArticleUIModel =
    ExistArticleUIModel(title, description, images.map { it.toUIModel() })

fun ExistArticleUIModel.toDomain(): ExistArticle =
    ExistArticle(title, description, images.map { it.toDomain() })
