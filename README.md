# Welcome to My Compose Playground!

This is an example using [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) and [Jetpack Compose](https://developer.android.com/jetpack/compose?hl=ja).

It lists the github repositories of a specified user.

### Platforms
* `Android` - Jetpack Compose, Kotlin Multiplatform(Android)
* `iOS` - SwiftUI, Kotlin Multiplatform(Native)
* `Web` - Compose for Web, Kotlin Multiplatform(JS)
* `Desktop` - Compose for Desktop, Kotlin Multiplatform(JVM)

### Modules / Folders
* `:android` - Android entry point
* `ios` - iOS entry point and UI
* `:desktop` - Desktop entry point
* `:web` - Web entry point and UI
* `:common:share` - Common logics for all platforms
* `:common:compose-util` - Utilities of Compose for android, desktop and web
* `:common:compose-ui` - UI for android and desktop

### Libraries
* [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization)
* [Ktor Client](https://github.com/ktorio/ktor)
* [Koin](https://github.com/InsertKoinIO/koin)

### Architecture
* MVVM Architecture with Kotlin Coroutines Flow

## How to Run
### Android
```
./gradlew installDebug
```

### iOS
Open and build the Xcode project located in `ios` folder.

### Desktop
```
./gradlew :desktop:run
```

### Web
```
./gradlew :web:jsBrowserRun
```