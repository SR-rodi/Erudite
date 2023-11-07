package ru.sr.erudite.data.repository

import ru.sr.erudite.data.api.AuthApi
import ru.sr.erudite.data.model.responseBody.BodyEmailPass
import ru.sr.erudite.domen.AuthRepository
import ru.sr.erudite.presentation.NetworkResponse
import ru.sr.erudite.presentation.exception.ApiException
import ru.sr.erudite.presentation.exception.NetworkException
import ru.sr.erudite.presentation.exception.UnSupportException

class AuthRepositoryImpl(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun signWithEmailAndPassword(
        email: String,
        password: String
    ): Result<String>{
        return runCatching {
            val response =
                authApi.signInWithPasswordEndEmail(
                    BodyEmailPass(
                        email = email,
                        password = password
                    )
                )
            when (response) {

                is NetworkResponse.Success ->response.body.token

                is NetworkResponse.ApiError -> {

                throw ApiException(
                    error = response.body.code,
                    message = response.body.message
                )
                }

                is NetworkResponse.NetworkError -> throw NetworkException()

                is NetworkResponse.UnknownError ->throw UnSupportException()
            }
        }
    }
}