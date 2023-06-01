package com.woowa.notice.service

import com.woowa.notice.dto.ArticleDTO
import com.woowa.notice.dto.ExistArticleDTO
import com.woowa.notice.dto.NoticeDTO
import com.woowa.notice.dto.NoticeListDTO
import retrofit2.Call
import retrofit2.http.*

interface NoticeService {

    @GET("/notice")
    fun getNotices(): Call<NoticeListDTO>

    @GET("/notice/{noticeId}")
    fun getNotice(
        @Path("noticeId") noticeId: Long,
    ): Call<NoticeDTO>

    @DELETE("/notice/{noticeId}")
    fun deleteNotice(
        @Path("noticeId") noticeId: Long,
    ): Call<String>

    @POST("/notice")
    fun postNotice(
        @Body article: ArticleDTO,
    ): Call<Unit>

    @PUT("/notice/{noticeId}")
    fun putNotice(
        @Path("noticeId") noticeId: Long,
        @Body article: ExistArticleDTO
    ): Call<Unit>
}
