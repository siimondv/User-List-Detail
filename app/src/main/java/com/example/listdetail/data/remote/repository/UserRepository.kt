package com.example.listdetail.data.remote.repository

import com.example.listdetail.data.remote.api.APIService
import com.example.listdetail.domain.model.User
import com.example.listdetail.utils.Constants
import com.example.listdetail.utils.NetworkResult
import javax.inject.Inject



class UserRepository @Inject constructor(private val apiService: APIService) {

    suspend fun getUsers()
            : NetworkResult<List<User>> {
        return try {
            val response = apiService.getUsers()

            if (response.isSuccessful) {
                response.body()?.let {
                    NetworkResult.Success(it)
                } ?: NetworkResult.Error(Constants.NO_USERS_FOUND)
            } else {
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResult.Error(Constants.NO_USERS_FOUND)
        }
    }

}