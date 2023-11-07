package ru.sr.erudite.domen.usecase

interface SignWithEmailAndPasswordUseCase {
    suspend operator fun invoke(email: String,password: String): Result<String>
}