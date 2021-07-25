import SwiftUI
import shared

struct RepoList: View {
    let repoList: [Repo]

    var body: some View {
        List(repoList, id: \.self.id) { repo in
            RepoRow(repo: repo)
        }
    }
}

struct RepoRow: View {
    let repo: Repo

    var body: some View {
        Text(repo.name)
    }
}
