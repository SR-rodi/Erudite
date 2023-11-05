package ru.sr.erudite.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.sr.erudite.data.api.AuthApi

@Composable
fun AuthScreen(viewModel: AuthScreenViewModel = koinViewModel()) {

    val state = viewModel.state.collectAsState()

    Text(text = state.value)

}

class AuthScreenViewModel(
    private val api: AuthApi
) : ViewModel() {
    val state = MutableStateFlow("Loading")

    init {
        test()
    }

    private fun test() {
        viewModelScope.launch(Dispatchers.IO) {

            state.value = when (val a = api.test("10")) {
                is NetworkResponse.ApiError -> a.body.message
                is NetworkResponse.NetworkError -> a.error?.message.toString()
                is NetworkResponse.Success -> a.body.name
                is NetworkResponse.UnknownError -> a.error?.localizedMessage.toString()
            }
        }
    }

}