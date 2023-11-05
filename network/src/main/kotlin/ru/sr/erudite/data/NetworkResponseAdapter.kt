package ru.sr.erudite.data

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import ru.sr.erudite.presentation.NetworkResponse
import java.lang.reflect.Type

internal class NetworkResponseAdapter<Success:Any, Error:Any>(
    private val successType: Type,
    private val errorBodyConvertor: Converter<ResponseBody, Error>
) : CallAdapter<Success, Call<NetworkResponse<Success, Error>>> {
    override fun responseType(): Type {
        return successType
    }

    override fun adapt(call: Call<Success>): Call<NetworkResponse<Success, Error>> {
        return NetworkResponseCall(call, errorBodyConvertor)
    }

}