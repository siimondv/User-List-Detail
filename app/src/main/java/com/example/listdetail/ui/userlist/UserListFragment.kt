package com.example.listdetail.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.listdetail.base.BaseFragment
import com.example.listdetail.databinding.FragmentUserListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : BaseFragment<FragmentUserListBinding>() {

    private val userAdapter by lazy { UserAdapter() }

    private val userListViewModel: UserListViewModel by viewModels()

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserListBinding
        get() = FragmentUserListBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        initUi()
    }

    private fun initUi() {
        binding.usersRecyclerView.adapter = userAdapter

        observeResponse()
    }

    private fun observeResponse() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                userListViewModel.uiState.collect { state ->

                    state.errorMessage?.let {
                        showErrorToast("${state.errorMessage} ")
                    }

                    if (state.user.isNotEmpty()) {
                        userAdapter.differ.submitList(state.user)
                    }
                    handleLoading(state.isLoading)


                }
            }
        }


    }

    private fun handleLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }


}