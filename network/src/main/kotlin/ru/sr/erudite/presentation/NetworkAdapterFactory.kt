package ru.sr.erudite.presentation

import retrofit2.CallAdapter
import ru.sr.erudite.data.NetworkResponseAdapterFactory

interface NetworkAdapterFactory {
    companion object {
        fun create(): CallAdapter.Factory {
            return NetworkResponseAdapterFactory()
        }
    }
}