import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        Sample().sample()
    }

    var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
