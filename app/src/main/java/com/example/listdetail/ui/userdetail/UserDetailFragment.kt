package com.example.listdetail.ui.userdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.listdetail.R
import com.example.listdetail.base.BaseFragment
import com.example.listdetail.databinding.FragmentUserDetailBinding
import com.example.listdetail.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<FragmentUserDetailBinding>() {

    private val args: UserDetailFragmentArgs by navArgs()

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserDetailBinding
        get() = FragmentUserDetailBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        setUpCompetitionData(args.user)
    }

    @SuppressLint("SetTextI18n")
    private fun setUpCompetitionData(user: User) {
        binding.apply {
            Glide
                .with(requireContext())
                .load(user.avatarURL)
                .placeholder(R.drawable.user)
                .into(emblemImageView)


            userNameTextView.text = user.name
            userTypeTextView.text = "${userTypeTextView.text} ${user.type}"
            userContributionCountTextView.text = "${userContributionCountTextView.text} ${user.contributionCount}"
        }
    }


}