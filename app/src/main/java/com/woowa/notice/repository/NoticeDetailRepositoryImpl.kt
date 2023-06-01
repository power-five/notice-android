package com.woowa.notice.repository

import com.woowa.notice.domain.Notice
import com.woowa.notice.mapper.toDomain
import com.woowa.notice.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class NoticeDetailRepositoryImpl : NoticeDetailRepository {
    override fun getNotice(
        id: Long,
        onSuccess: (Notice) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        RetrofitClient.noticeService.getNotice(id).enqueue(
            createResponseCallback(
                onSuccess = { notice ->
                    val noticeDomain = notice.toDomain()
                    onSuccess(noticeDomain)
                },
                onFailure = onFailure,
            ),
        )
    }

    override fun deleteNotice(id: Long, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        RetrofitClient.noticeService.deleteNotice(id).enqueue(
            createResponseCallback(
                onSuccess = { onSuccess() },
                onFailure = onFailure,
            ),
        )
    }

    private inline fun <reified T> createResponseCallback(
        crossinline onSuccess: (T) -> Unit,
        crossinline onFailure: (Exception) -> Unit,
    ): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    onSuccess(responseBody)
                } else {
                    onFailure(Exception("Response unsuccessful"))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onFailure(IOException("Error getting response $t"))
            }
        }
    }
}
