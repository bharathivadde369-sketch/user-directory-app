# User Directory App

## Overview

User Directory App is a simple Android application built using Kotlin and Jetpack Compose. The app fetches user data from a REST API and displays it in a clean and user-friendly interface.

The application contains two screens:

* User List Screen
* User Detail Screen

Users can view the list of users and click on any user to view detailed information.

---

## Features

* Fetch user data from REST API
* Display users in list screen
* Navigate to user detail screen
* Loading state handling
* Error state handling
* Back navigation support

---

## Tech Stack

* Kotlin
* Jetpack Compose
* MVVM Architecture
* Repository Pattern
* Retrofit
* Kotlin Coroutines

---

## Architecture

Application follows clean separation of concerns using MVVM architecture.

Flow:

UI → ViewModel → Repository → API

* **UI Layer** → Compose screens
* **ViewModel Layer** → Handles UI state and business logic
* **Repository Layer** → Handles data source interaction
* **Network Layer** → Fetches API response using Retrofit

---

## Project Structure

app/

* data
* network
* presentation

---

## API Used

https://fake-json-api.mock.beeceptor.com/users

---

## Unit Tests

Included unit tests for:

* Repository layer
* ViewModel logic
* UI state validation

---

## Assumptions

* User data is fetched from the provided public mock API endpoint.
* The mock API may occasionally return inconsistent or malformed values for certain records. The application handles such cases gracefully by displaying valid available data or fallback values.
* The UI is intentionally kept simple and clean, focusing on functionality and readability as per assessment requirements.
* State-based navigation is used for simplicity instead of Navigation Compose.


---

## Future Improvements

* Add Navigation Compose
* Add Dependency Injection using Hilt
* Improve UI/UX
* Add advanced unit/UI testing
* Add offline caching using Room

---

## Screenshots

### List Screen

<img width="400" height="800" alt="user_list" src="https://github.com/user-attachments/assets/41ad6d8e-a600-4926-8bf7-2d75c37065c1" />




### Detail Screen


<img width="400" height="800" alt="user_details" src="https://github.com/user-attachments/assets/293ec9a3-43e1-4814-a6b6-3f98e42688e8" />



---

## Video Demo


https://github.com/user-attachments/assets/91570e5d-4dbb-4c6e-82e6-ed7c775d47d3




