package ru.sr.erudite.presentation.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.sr.erudite.domen.usecase.SignWithEmailAndPasswordUseCase

class SignInViewModel(
    private val signWithEmailAndPasswordUseCase: SignWithEmailAndPasswordUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<SignInState> = MutableStateFlow(SignInState.Content())
    val state = _state.asStateFlow()

    private var lastContent = SignInState.Content()

    fun signWithEmailAndPassword() {
        viewModelScope.launch(Dispatchers.IO) {
            signWithEmailAndPasswordUseCase.invoke(lastContent.email, lastContent.password)
                .onSuccess {
                    updateState(SignInState.Success)
                }.onFailure {
                    updateState(lastContent.copy(errorMessage = it.localizedMessage ?: "UnSupport"))
                }
        }
    }

    private fun updateState(state: SignInState) {
        if (state is SignInState.Content) {
            lastContent = state
            _state.value = lastContent
        } else {
            _state.value = state
        }
    }

    fun onEmailChange(email: String) {
        updateState(lastContent.copy(email = email))
    }

    fun onPasswordChange(password: String) {
        updateState(lastContent.copy(password = password))
    }

    fun clearEmail() {
        updateState(lastContent.copy(email = ""))
    }
}


sealed interface SignInState {
    data class Content(
        val email: String = "",
        val password: String = "",
        val errorMessage: String? = null
    ) : SignInState

    object Loading : SignInState
    object Success : SignInState

}