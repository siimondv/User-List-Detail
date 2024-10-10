package com.example.listdetail.domain.usecase

import com.example.listdetail.data.remote.repository.UserRepository
import com.example.listdetail.domain.model.User
import com.example.listdetail.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(): Flow<NetworkResult<List<User>>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(userRepository.getUsers())
        }.flowOn(dispatcher)

    }
}