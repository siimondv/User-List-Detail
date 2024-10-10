package com.example.listdetail.data.remote.api

import com.example.listdetail.domain.model.User
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("contributors")
    suspend fun getUsers(): Response<List<User>>
}