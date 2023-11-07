package ru.sr.erudite.data.model.responseBody

import com.google.gson.annotations.SerializedName

class BodyEmailPass(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)