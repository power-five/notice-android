package com.woowa.notice.util

import retrofit2.Call
import retrofit2.Callback

fun <T> createResponseCallback(
    onSuccess: (T) -> Unit,
    onFailure: (Exception) -> Unit,
): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) {
            val responseBody = response.body()
            if (responseBody != null) {
                onSuccess(responseBody)
            } else {
                onFailure(Exception("Response unsuccessful"))
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            println("Response unsuccessful: ${t.message}")
            onFailure(Exception("Response unsuccessful"))
        }
    }
}