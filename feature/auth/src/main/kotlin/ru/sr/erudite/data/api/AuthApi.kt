package ru.sr.erudite.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.sr.erudite.data.model.dto.TokenDto
import ru.sr.erudite.data.model.dto.UserIdDto
import ru.sr.erudite.data.model.responseBody.BodyEmailPass
import ru.sr.erudite.data.model.responseBody.BodyRegistration
import ru.sr.erudite.presentation.NetworkResponse

interface AuthApi {

    @POST("/auth/email/registration")
    suspend fun registration(@Body body: BodyRegistration): UserIdDto

    @GET("/auth/email")
    suspend   fun signInWithPasswordEndEmail(@Body body: BodyEmailPass): TokenDto

    @GET("/auth/google/{id}")
    suspend fun signInWithGoogle(@Path("id") id: String): TokenDto

    @GET("/test/{id}")
    suspend fun test(@Path("id") id: String): NetworkResponse<Test, ApiError>
}


class ApiError(
    val code: String,
    val message: String,
)

data class Test(
    val id: Int,
    val name: String
)
