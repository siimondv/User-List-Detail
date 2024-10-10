package com.example.listdetail.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class User(
    @SerializedName("login") val name: String,
    val type: String,
    @SerializedName("contributions") val contributionCount: Int,
    @SerializedName("avatar_url") val avatarURL: String
) : Serializable

