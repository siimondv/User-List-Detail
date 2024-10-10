package com.example.listdetail.ui.userlist

import androidx.lifecycle.ViewModel
import com.example.listdetail.domain.model.User
import com.example.listdetail.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.annotation.concurrent.Immutable
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.listdetail.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserListState())
    val uiState = _uiState.asStateFlow()

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            getUsersUseCase().catch { e ->
                _uiState.value = UserListState(user = emptyList())
            }.collect { result ->
                when (result) {
                    is NetworkResult.Error -> {
                        _uiState.value = UserListState(
                            errorMessage = result.message.toString(),
                            isLoading = false
                        )

                    }

                    is NetworkResult.Loading -> {

                        _uiState.value = UserListState(isLoading = true)

                    }

                    is NetworkResult.Success -> {

                        _uiState.value = UserListState(
                            user = result.data ?: emptyList(),
                            isLoading = false
                        )

                    }
                }
            }

        }

    }
}

@Immutable
data class UserListState(
    val user: List<User> = emptyList(),
    val errorMessage: String? = null,
    val isLoading: Boolean = true
)