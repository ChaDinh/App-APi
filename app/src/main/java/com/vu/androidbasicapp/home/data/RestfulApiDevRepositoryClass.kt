package com.vu.androidbasicapp.home.data

import com.vu.androidbasicapp.home.network.RestfulApiDevService
import retrofit2.Response
import javax.inject.Inject

class RestfulApiDevRepositoryClass @Inject constructor(
    private val restfulDevApiService: RestfulApiDevService
) {

    private fun <T> handleResponse(response: Response<T>): T {
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("Request failed with error: ${response.code()} ${response.message()}")
        }
    }

    suspend fun getObjectsByKeypass(keypass: String): List<ResponseItem> {
        val response = restfulDevApiService.getObjectsByKeypass(keypass)
        return handleResponse(response)
    }


    suspend fun login(username: String, password: String): LoginResponse {
        val response = restfulDevApiService.login(LoginRequest(username, password))
        return handleResponse(response)
    }

    suspend fun getSingleObject(id: Int): ResponseItem {
        val response = restfulDevApiService.getSingleObject(id)
        return handleResponse(response)
    }

    suspend fun addSingleObject(item: AddObjectRequest): AddObjectResponse {
        val response = restfulDevApiService.addObject(item)
        return handleResponse(response)
    }
}
