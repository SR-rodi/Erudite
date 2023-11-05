package ru.sr.erudite.data

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import ru.sr.erudite.presentation.NetworkResponse

internal class NetworkResponseCall<S:Any, E:Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<NetworkResponse<S, E>> {
    override fun clone(): Call<NetworkResponse<S, E>> {
        return NetworkResponseCall(delegate.clone(), errorConverter)
    }

    override fun execute(): Response<NetworkResponse<S, E>> {
        throw UnsupportedOperationException("NetworkResponseCall non support execute")
    }

    override fun enqueue(callback: Callback<NetworkResponse<S, E>>) {
        return delegate.enqueue(NetworkResponseCallback(this, callback, errorConverter))
    }

    override fun isExecuted(): Boolean {
        return delegate.isExecuted
    }

    override fun cancel() {
        delegate.cancel()
    }

    override fun isCanceled(): Boolean {
        return delegate.isCanceled
    }

    override fun request(): Request {
        return delegate.request()
    }

    override fun timeout(): Timeout {
        return delegate.timeout()
    }
}