# Compose MVI Clean Architecture

A Boilerplate Android project using **Jetpack Compose**, following **Clean Architecture** principles and the **MVI (Model-View-Intent)** pattern. Designed for scalability, maintainability, and testability.

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
    git clone https://github.com/your-username/compose-mvi-clean-architecture.git
    ```
2.  **Open with Android Studio:** (Ladybug version or newer recommended).
3.  **Sync Gradle:** Wait for the library download process to complete.
4.  **Run the project:** Click `Run` to install on a virtual or physical device.

## 📝 Key Components

-   **`BaseViewModel`**: Manages State, Intent, and Effect in a unified way.
-   **`BaseScreen`**: A wrapper for Compose screens to handle Side Effects and lifecycle.
-   **`BaseUseCase`**: Base class for Use Cases to standardize data handling.

---
⭐ If you find this project useful, please give it a star!
