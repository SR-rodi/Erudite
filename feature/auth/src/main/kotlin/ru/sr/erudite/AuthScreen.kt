package ru.sr.erudite

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ru.sr.erudite.data.network.NetworkResponse

@Composable
fun AuthScreen() {

    var message by remember {
        mutableStateOf("Loading")
    }

    LaunchedEffect(key1 = Unit){
        val test =  TestApi.api().test("10")
        Log.d("Kart","$test")
        message = when(test){

            is NetworkResponse.ApiError -> test.body.message
            is NetworkResponse.NetworkError -> test.error?.message.toString()
            is NetworkResponse.Success -> test.body.name
            is NetworkResponse.UnknownError -> test.error?.localizedMessage.toString()
        }
    }

    Text(text = message)

}