package com.example.listdetail.ui.userlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listdetail.R
import com.example.listdetail.databinding.UserItemBinding
import com.example.listdetail.domain.model.User


class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(data: User) {

            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(data.avatarURL)
                    .placeholder(R.drawable.user)
                    .into(userImageView)

                userNameTextView.text = data.name
                userTypeTextView.text = "${userTypeTextView.text} ${data.type}"
                userContributionCountTextView.text = "${userContributionCountTextView.text} ${data.contributionCount}"
            }
        }

        init {
            itemView.setOnClickListener {
                val action =
                    UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(differ.currentList[layoutPosition])
                it.findNavController().navigate(action)
            }
        }

    }

    private val diffCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.ViewHolder {
        val view =
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.onBind(currentItem)
    }

    override fun getItemCount(): Int {

        return differ.currentList.size
    }


}
