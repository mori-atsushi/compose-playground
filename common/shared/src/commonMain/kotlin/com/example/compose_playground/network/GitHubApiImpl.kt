package com.example.compose_playground.network

import com.example.compose_playground.model.Repo
import io.ktor.client.*
import io.ktor.client.request.*

internal class GitHubApiImpl(
    private val httpClient: HttpClient
) : GitHubApi {
    companion object {
        const val GITHUB_API_URL = "https://api.github.com"
    }

    override suspend fun getRepoList(user: String): List<Repo> {
        return httpClient.get("$GITHUB_API_URL/users/$user/repos")
    }

    override suspend fun getRepoDetails(user: String, repoName: String): Repo {
        return httpClient.get("$GITHUB_API_URL/users/$user/$repoName")
    }
}
