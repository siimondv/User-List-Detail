# User-List-Detail
A simple list-detail Android app that displays a list of users using the github api and a random repository. Itallows users to tap an item to view its detailed information on a separate screen.

# Clean Architecture & MVVM
This project follows Clean Architecture principles and implements the MVVM (Model-View-ViewModel) design pattern for organizing code and ensuring separation of concerns.

There are 3 main modules in the project:
- [data](data) This module handles data management, including repositories, data sources, and the logic for interacting with APIs and local databases.
- [domain](domain) Contains the core business logic and use cases that define how data is processed and accessed, serving as a bridge between the data and UI layers.
- [ui](ui) Responsible for the user interface, this module includes Activities, Fragments, ViewModels, and other components that present data to the user and handle user interactions.

# Features and technologies
1. Gradle build config is based on **Kotlin DSL**
2. **Version catalog** is used for dependency management
3. Dependency injection is handled using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
4. Network requests are managed using [Retrofit](https://square.github.io/retrofit/) for API communication
5. UI components are built using **Fragments**
6. Navigation between screens is handled via **Android Navigation Component**
7. The user list is displayed using **RecyclerView**
8. Image loading and caching is done with [Glide](https://github.com/bumptech/glide)
9. Toast messages are implemented using [Toasty](https://github.com/GrenderG/Toasty)

   
