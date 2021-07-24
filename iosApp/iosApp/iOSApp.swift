import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        EntryKt.setupDI()
        Sample().sample()
    }

    var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
