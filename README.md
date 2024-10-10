# User-List-Detail
A simple list-detail Android app that displays a list of users using the github api and a random repository. It allows users to tap an item to view its detailed information on a separate screen.

# Clean Architecture & MVVM
This project follows Clean Architecture principles and implements the MVVM (Model-View-ViewModel) design pattern for organizing code and ensuring separation of concerns.

There are 3 main modules in the project:
- [data](data) This module handles data management, including repositories, data sources, and the logic for interacting with APIs and local databases.
- [domain](domain) Contains the core business logic and use cases that define how data is processed and accessed, serving as a bridge between the data and UI layers.
- [ui](ui) Responsible for the user interface, this module includes Activities, Fragments, ViewModels, and other components that present data to the user and handle user interactions.


![image](https://github.com/user-attachments/assets/6d785207-944d-4a9c-8900-621641d0e15e)

## ScreenShots
 <table>
  <tr>
    <th>Home Screen </th>
    <th>Details Screen</th>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/8119e54c-fc35-46c4-8daf-ab4446d68304" width="350"></td>
    <td><img src="https://github.com/user-attachments/assets/07f22733-46a2-4857-8360-020b072f9d6f" width="350"></td>
  </tr>
 </table>


# Features and technologies
1. Gradle build config is based on **Kotlin DSL**
2. **Version catalog** is used for dependency management
3. Dependency injection is handled using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
4. Network requests are managed using [Retrofit](https://square.github.io/retrofit/) for API communication
5. **Coroutines** for asynchronous programming
6. UI components are built using **Fragments**
7. Navigation between screens is handled via **Android Navigation Component**
8. The user list is displayed using **RecyclerView**
9. Image loading and caching is done with [Glide](https://github.com/bumptech/glide)
10. Toast messages are implemented using [Toasty](https://github.com/GrenderG/Toasty)

## API
The used api to get the users :  http://api.football-data.org/v4/](https://api.github.com/repos/
with endPoint `android/compose-samples/contributors/`

   
