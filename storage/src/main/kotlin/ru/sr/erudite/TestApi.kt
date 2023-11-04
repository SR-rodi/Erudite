package ru.sr.erudite

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.sr.erudite.data.network.NetworkResponseAdapterFactory
import ru.sr.erudite.domain.AuthApi

object TestApi {

    private val retrofit =
        Retrofit.Builder().baseUrl("http://192.168.50.195:8080")
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().apply {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    })
                }.build()
            ).build()

    fun api(): AuthApi = retrofit.create()
}