package com.tzion.android_services_sample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val GITHUB_BASE_URL = "https://api.github.com/"

object GitHubRetrofitFactory {
    fun <T> createGitHubRetrofitImpl(tClass: Class<T>): T {
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(tClass)
    }
}