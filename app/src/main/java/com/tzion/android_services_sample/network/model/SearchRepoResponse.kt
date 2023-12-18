package com.tzion.android_services_sample.network.model

import com.google.gson.annotations.SerializedName

data class SearchRepoResponse(@SerializedName("items") val items: List<SearchRepoItem>)
