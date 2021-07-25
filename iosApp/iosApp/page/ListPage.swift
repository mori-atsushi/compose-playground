import SwiftUI
import shared

struct ListPage: View {
    private let viewModel: IOSListViewModel
    @State private var output: ListViewModel.Output

    init() {
        let viewModel = ViewModelKt.getListViewModel()
        self.viewModel = viewModel
        self.output = viewModel.initialOutput
    }

    var body: some View {
        VStack {
            SearchBox(
                value: output.userName,
                onValueChange: { value in
                    viewModel.input(input: ListViewModel.InputSetUserName(userName: value))
                },
                onSubmit: {
                    viewModel.input(input: ListViewModel.InputSubmit())
                }
            )
            RepoList(
                repoList: output.repoList
            )
        }
            .onAppear {
                viewModel.observe { output in
                    self.output = output
                }
            }
            .onDisappear { viewModel.clear() }
    }
}
