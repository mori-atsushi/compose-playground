package com.example.compose_playground.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(
    val id: Long,
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    val owner: User,
    @SerialName("html_url")
    val htmlUrl: String,
    val description: String?,
    val url: String,
    @SerialName("git_url")
    val gitUrl: String,
    @SerialName("ssh_url")
    val sshUrl: String,
    @SerialName("clone_url")
    val cloneUrl: String,
    @SerialName("svn_url")
    val svnUrl: String,
    val homepage: String?,
    @SerialName("stargazers_count")
    val stargazersCount: Int,
    @SerialName("watchers_count")
    val watchers_count: Int,
    val language: String?,
    @SerialName("has_issues")
    val hasIssues: Boolean,
    @SerialName("has_downloads")
    val hasDownloads: Boolean,
    @SerialName("has_wiki")
    val hasWiki: Boolean,
    @SerialName("has_pages")
    val hasPages: Boolean,
    @SerialName("forks_count")
    val forksCount: Int,
    @SerialName("open_issues_count")
    val openIssuesCount: Int,
    val forks: Int,
    @SerialName("open_issues")
    val openIssues: Int,
    val watchers: Int,
    @SerialName("default_branch")
    val defaultBranch: String
)