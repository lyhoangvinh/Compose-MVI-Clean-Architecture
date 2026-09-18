# Compose MVI Clean Architecture – Production Template

A reusable Kotlin Android template using **Jetpack Compose**, **Material 3**, **Clean Architecture** and the **MVI (Model-View-Intent)** pattern. It intentionally contains no product services, analytics, authentication, Firebase, or flavors.

## Platform baseline

- API 26 minimum; compile/target API 36 (Android 16).
- JDK 17, AGP 8.10.1, and Gradle 8.11.1 are deliberately pinned as a compatible toolchain.
- `MainActivity` installs the AndroidX splash screen before startup and calls `enableEdgeToEdge()` before composing UI.
- The activity opts into Android's predictive-back dispatcher.

### Insets contract

Use `AppScaffold` for full-screen Compose destinations. It is the default boundary for display cutouts, status/navigation bars, gesture navigation, and IME. Its content lambda receives an already-safe modifier:

```kotlin
AppScaffold(topBar = { TopAppBar(title = { Text("Screen") }) }) { contentModifier ->
    LazyColumn(modifier = contentModifier) { /* content */ }
}
```

Material `TopAppBar` and `NavigationBar` consume their own visual insets. Do not add fixed system-bar heights or duplicate system/IME padding inside a normal `AppScaffold` screen. Custom dialogs and sheets should apply their appropriate `WindowInsets` at their own boundary.

### Release and data policy

- Release builds run R8 and resource shrinking. Do not disable either to solve a library problem.
- Room uses KSP and exports schemas to `data/schemas`. Add migrations for real schema changes; the template intentionally does not use destructive migration fallback.
- Moshi models should use `@JsonClass(generateAdapter = true)`, which produces R8-safe generated adapters.
- Hilt, Room, and Moshi generated code have library consumer rules. `app/proguard-rules.pro` intentionally has no broad keep rules.
- HTTP body logging is debug-only, so release builds do not log request/response contents.

## 🚀 Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Dependency Injection:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Networking:** [Retrofit](https://square.github.io/retrofit/) & [OkHttp](https://square.github.io/okhttp/)
- **Database:** [Room](https://developer.android.com/training/data-storage/room)
- **Concurrency:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)
- **JSON Parsing:** [Moshi](https://github.com/square/moshi)
- **Image Loading:** [Coil](https://coil-kt.github.io/coil/)
- **Navigation:** [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)

## 🏗️ Architecture

The project is divided into 3 main modules following Clean Architecture:

1.  **`domain`**: Contains Business Logic, Entities, Repository Interfaces, and Use Cases. This module is pure Kotlin and has no Android dependencies.
2.  **`data`**: Implements Repository Interfaces from the Domain layer. Manages data sources like API (Remote) and Database (Local), along with Mappers to convert DTOs to Domain Models.
3.  **`app`**: Contains UI (Compose), ViewModels, and DI Modules. This is where the MVI pattern is implemented.

### MVI (Model-View-Intent) Pattern

Each screen is built upon:
-   **UiState:** The single source of truth for the UI state (Loading, Success, Error).
-   **UiIntent:** Actions initiated by the user or system events.
-   **UiEffect:** One-time side effects like Navigation or showing a Snackbar/Toast.

## 📁 Project Structure

```text
app/
 ├── base/                  # Base classes: BaseViewModel, MviContract
 ├── di/                    # Hilt Modules (App level)
 ├── navigation/            # Navigation configuration and Routes
 ├── ui/
 │    ├── components/       # Reusable UI components
 │    ├── home/             # Home Screen (MVI)
 │    └── detail/           # Detail Screen (MVI)
data/
 ├── local/                 # Room Database, DAOs, Entities
 ├── remote/                # Retrofit API, DTOs
 ├── repository/            # Repository implementation
 └── di/                    # Hilt Modules for Data layer
domain/
 ├── model/                 # Domain Entities
 ├── repository/            # Repository Interfaces
 └── usecase/               # Business Logic Use Cases
```

## 🛠️ Setup Instructions

1.  **Clone the project:**
    ```bash
    git clone https://github.com/lyhoangvinh/Compose-MVI-Clean-Architecture.git
    ```
2.  **Install JDK 17** and set `JAVA_HOME` to it.
3.  **Open with Android Studio:** use a current stable release with JDK 17 selected.
4.  **Verify:** run `./gradlew clean test lint assembleDebug assembleRelease` (or `gradlew.bat` on Windows).
5.  **Run:** install a debug or release APK on a virtual or physical device.

## 📝 Key Components

-   **`BaseViewModel`**: Manages State, Intent, and Effect in a unified way.
-   **`BaseScreen`**: A wrapper for Compose screens to handle Side Effects and lifecycle.
-   **`BaseUseCase`**: Base class for Use Cases to standardize data handling.

---
⭐ If you find this project useful, please give it a star!
