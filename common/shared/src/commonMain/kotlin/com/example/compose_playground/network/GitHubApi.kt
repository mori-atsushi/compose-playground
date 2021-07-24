package com.example.compose_playground.network

import com.example.compose_playground.model.Repo

interface GitHubApi {
    suspend fun getRepoList(user: String): List<Repo>
    suspend fun getRepoDetails(user: String, repoName: String): Repo
}
