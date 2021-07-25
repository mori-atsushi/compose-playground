import SwiftUI
import shared

struct TopPage: View {
    private let viewModel: IOSTopViewModel = ViewModelKt.getTopViewModel()

    @State private var output: TopViewModel.Output?

    var body: some View {
        RepoList(
            repoList: output?.repoList ?? []
        )
            .onAppear {
                viewModel.observe { output in
                    self.output = output
                }
            }
            .onDisappear { viewModel.clear() }
    }
}
