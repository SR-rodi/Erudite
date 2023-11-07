package ru.sr.erudite.domen.usecase.impl

import ru.sr.erudite.domen.AuthRepository
import ru.sr.erudite.domen.usecase.SignWithEmailAndPasswordUseCase

class SignWithEmailAndPasswordUseCaseImpl(
    private val authRepository: AuthRepository
) : SignWithEmailAndPasswordUseCase {
    override suspend fun invoke(email: String,password: String): Result<String> {
        return authRepository.signWithEmailAndPassword(email = email, password)
    }
}