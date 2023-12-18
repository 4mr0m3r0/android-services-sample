package com.tzion.android_services_sample.network.model

import com.google.gson.annotations.SerializedName

data class SearchRepoItem(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val stargazers: String,
    @SerializedName("watchers") val watchers: String,
)
