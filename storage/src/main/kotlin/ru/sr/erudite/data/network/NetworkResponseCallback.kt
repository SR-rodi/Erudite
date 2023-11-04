package ru.sr.erudite.data.network

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

internal class NetworkResponseCallback<S:Any, E:Any>(
    private val call: NetworkResponseCall<S, E>,
    private val callback: Callback<NetworkResponse<S, E>>,
    private val errorConverter: Converter<ResponseBody, E>
) : Callback<S> {
    override fun onResponse(call: Call<S>, response: Response<S>) {
        val body = response.body()
        val error = response.errorBody()
        if (response.isSuccessful) {
            onResponseSuccessful(body = body, callback = callback)
        } else {
            onNotSuccessfulResponse(error)
        }
    }

    override fun onFailure(call: Call<S>, t: Throwable) {
        val networkResponse = when (t) {
            is IOException -> NetworkResponse.NetworkError(t)
            else -> NetworkResponse.UnknownError(t)
        }

        callback.onResponse(this.call, Response.success(networkResponse))
    }

    private fun onResponseSuccessful(body: S?, callback: Callback<NetworkResponse<S, E>>) {

        val response = if (body == null) {
            NetworkResponse.UnknownError(null)
        } else {
            NetworkResponse.Success(body)
        }
        callback.onResponse(call, Response.success(response))
    }

    private fun onNotSuccessfulResponse(error: ResponseBody?) {
        val errorBody = when {
            error == null || error.contentLength() == 0L -> null
            else -> try {

                errorConverter.convert(error)
            } catch (e: Exception) {
                Log.e("KArt","Adapter = $e")
                null
            }
        }




        val response = if (errorBody == null) {
            NetworkResponse.UnknownError(null)
        } else {
            NetworkResponse.ApiError(errorBody)
        }
        callback.onResponse(call, Response.success(response))
    }

}