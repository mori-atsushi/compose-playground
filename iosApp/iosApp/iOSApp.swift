import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        EntryKt.setupDI()
    }

    var body: some Scene {
		WindowGroup {
            TopPage()
		}
	}
}
