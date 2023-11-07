package ru.sr.erudite.domen

interface AuthRepository {

    suspend fun signWithEmailAndPassword(email: String, password: String): Result<String>
}