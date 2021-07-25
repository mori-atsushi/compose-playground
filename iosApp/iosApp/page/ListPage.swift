import SwiftUI
import shared

struct ListPage: View {
    private let viewModel: IOSListViewModel
    @State private var state: ListViewModel.State

    init() {
        let viewModel = ViewModelKt.getListViewModel()
        self.viewModel = viewModel
        self.state = viewModel.initialState
    }

    var body: some View {
        VStack {
            SearchBox(
                value: state.userName,
                onValueChange: { value in
                    viewModel.action(action: ListViewModel.ActionSetUserName(userName: value))
                },
                onSubmit: {
                    viewModel.action(action: ListViewModel.ActionSubmit())
                }
            )
            RepoList(
                repoList: state.repoList
            )
        }
            .onAppear {
                viewModel.observeState { state in
                    self.state = state
                }
            }
            .onDisappear { viewModel.clear() }
    }
}
