package com.cocoa.corutines

import com.cocoa.corutines.retrofit.GitHubService
import com.cocoa.corutines.retrofit.Repo
import com.cocoa.corutines.retrofit.RequestData
import com.cocoa.corutines.retrofit.User
import org.slf4j.LoggerFactory
import retrofit2.Response

fun main() {

}



fun loadContributorsBlocking(service: GitHubService, req: RequestData) : List<User> {
    val repos = service
        .getOrgReposCall(req.org)
        .execute() // Executes request and blocks the current thread
        .also { logRepos(req, it) }
        .body() ?: emptyList()

    return repos.flatMap { repo ->
        service
            .getRepoContributorsCall(req.org, repo.name)
            .execute() // Executes request and blocks the current thread
            .also { logUsers(repo, it) }
            .bodyList()
    }.aggregate()
}



fun <T> Response<List<T>>.bodyList(): List<T> {
    return body() ?: emptyList()
}


val log = LoggerFactory.getLogger("Contributors")

fun log(msg: String?) {
    log.info(msg)
}

fun logRepos(req: RequestData, response: Response<List<Repo>>) {
    val repos = response.body()
    if (!response.isSuccessful || repos == null) {
        log.error("Failed loading repos for ${req.org} with response: '${response.code()}: ${response.message()}'")
    }
    else {
        log.info("${req.org}: loaded ${repos.size} repos")
    }
}

fun logUsers(repo: Repo, response: Response<List<User>>) {
    val users = response.body()
    if (!response.isSuccessful || users == null) {
        log.error("Failed loading contributors for ${repo.name} with response '${response.code()}: ${response.message()}'")
    }
    else {
        log.info("${repo.name}: loaded ${users.size} contributors")
    }
}


fun List<User>.aggregate(): List<User> =
    this