import SwiftUI
import shared

struct ContentView: View {
    let viewModel = ViewModelKt.getTopViewModel()
	let greet = Greeting().greeting()

	var body: some View {
		Text(greet)
            .onDisappear { viewModel.clear() }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
