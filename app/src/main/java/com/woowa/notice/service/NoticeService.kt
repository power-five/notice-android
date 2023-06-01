package com.woowa.notice.service

import com.woowa.notice.dto.NoticeDTO
import com.woowa.notice.dto.NoticeListDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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
        @Body notice: NoticeDTO,
    )
}
