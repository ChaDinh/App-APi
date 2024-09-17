package com.vu.androidbasicapp
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.data.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: RestfulApiDevRepositoryClass) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResponse?>()
    val loginResult: LiveData<LoginResponse?> get() = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                _loginResult.value = response
            } catch (e: Exception) {
                _loginResult.value = null
                Log.e("LoginViewModel", "Login failed", e)
            }
        }
    }
}