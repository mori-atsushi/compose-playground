import SwiftUI
import shared

struct TopPage: View {
    private let viewModel: IOSTopViewModel
    @State private var output: TopViewModel.Output

    init() {
        let viewModel = ViewModelKt.getTopViewModel()
        self.viewModel = viewModel
        self.output = viewModel.initialOutput
    }

    var body: some View {
        VStack {
            SearchBox(
                value: output.userName,
                onValueChange: { value in
                    viewModel.input(input: TopViewModel.InputSetUserName(userName: value))
                },
                onSubmit: {
                    viewModel.input(input: TopViewModel.InputSubmit())
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
