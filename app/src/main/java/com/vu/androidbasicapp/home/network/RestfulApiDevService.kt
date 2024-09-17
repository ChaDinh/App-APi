package com.vu.androidbasicapp.home.network
import com.vu.androidbasicapp.home.data.AddObjectRequest
import com.vu.androidbasicapp.home.data.AddObjectResponse
import com.vu.androidbasicapp.home.data.LoginRequest
import com.vu.androidbasicapp.home.data.LoginResponse
import com.vu.androidbasicapp.home.data.ResponseItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestfulApiDevService {

    @POST("sydney/auth")
    suspend fun login(@Body requestBody: LoginRequest): Response<LoginResponse>

    // Updated GET request with keypass in URL
    @GET("dashboard/{keypass}")
    suspend fun getObjectsByKeypass(@Path("keypass") keypass: String): Response<List<ResponseItem>>

    @GET("dashboard/{id}")
    suspend fun getSingleObject(@Path("id") id: Int): Response<ResponseItem>

    @POST("dashboard")
    suspend fun addObject(@Body requestBody: AddObjectRequest): Response<AddObjectResponse>
}
