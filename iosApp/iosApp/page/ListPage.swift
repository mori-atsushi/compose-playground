import SwiftUI
import shared

struct ListPage: View {
    @ObservedObject private var viewModel: ListViewModel
    
    init(_ viewModel: ListViewModel = ListViewModel()) {
        self.viewModel = viewModel
    }

    var body: some View {
        VStack {
            SearchBox(
                value: viewModel.state.userName,
                onValueChange: { value in
                    viewModel.action(.setUserName(userName: value))
                },
                onSubmit: {
                    viewModel.action(.submit)
                }
            )
            RepoList(
                repoList: viewModel.state.repoList
            )
        }
    }
}
