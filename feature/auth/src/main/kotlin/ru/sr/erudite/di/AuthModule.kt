package ru.sr.erudite.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import ru.sr.erudite.presentation.AuthScreenViewModel
import ru.sr.erudite.data.api.AuthApi
import ru.sr.erudite.data.repository.AuthRepositoryImpl
import ru.sr.erudite.domen.AuthRepository
import ru.sr.erudite.domen.usecase.SignWithEmailAndPasswordUseCase
import ru.sr.erudite.domen.usecase.impl.SignWithEmailAndPasswordUseCaseImpl
import ru.sr.erudite.presentation.signIn.SignInViewModel

fun authModule() = listOf(auth())

private fun auth() = module {
    single<AuthApi> { get<Retrofit>().create() }

    singleOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
    singleOf(::SignWithEmailAndPasswordUseCaseImpl) { bind<SignWithEmailAndPasswordUseCase>() }

    viewModelOf(::AuthScreenViewModel)
    viewModelOf(::SignInViewModel)
}