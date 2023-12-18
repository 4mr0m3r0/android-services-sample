package com.tzion.android_services_sample.network

import com.tzion.android_services_sample.network.model.SearchRepoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubRetrofit {
    @GET("search/repositories")
    suspend fun getSearchRepositories(@Query("q") query: String): SearchRepoResponse
}