package ru.sr.erudite.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.sr.erudite.presentation.NetworkAdapterFactory

fun networkModule() = listOf(retrofit())

fun retrofit() = module {

    single(named("HttpLoggingInterceptor")) {
        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
        }.build()
    }

    single {
        Retrofit.Builder().baseUrl("http://192.168.50.195:8080")
            .addCallAdapterFactory(NetworkAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named("HttpLoggingInterceptor")))
            .build()
    }



}