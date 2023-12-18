package com.tzion.android_services_sample.network

import com.tzion.android_services_sample.network.model.SearchRepoResponse
import kotlinx.coroutines.delay

class SearchRepositories(private val gitHubRetrofit: GitHubRetrofit) {
    suspend fun getSearchRepositories(query: String): SearchRepoResponse {
        delay(10000)
        return gitHubRetrofit.getSearchRepositories(query)
    }
}