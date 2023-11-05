package ru.sr.erudite.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import ru.sr.erudite.presentation.AuthScreenViewModel
import ru.sr.erudite.data.api.AuthApi

fun authModule() = listOf(auth())

private fun auth() = module {
    single<AuthApi> { get<Retrofit>().create() }

    viewModelOf(::AuthScreenViewModel)
}