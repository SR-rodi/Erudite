package ru.sr.erudite.presentation.exception

class ApiException(
    error: String,
    message: String,
) : Exception() {

    companion object {
        const val VE_100 = "VE_100"
        const val VP_101 = "VE_101"
        const val VP_100 = "VP_100"
        const val VE_102 = "VP_102"
    }
}

class NetworkException():Exception()
class UnSupportException():Exception()