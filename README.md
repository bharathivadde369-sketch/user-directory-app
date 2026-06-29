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

* User data is fetched from a public mock API.
* Basic UI design is implemented as per assessment requirements.
* State-based navigation is used for simplicity.

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
<img width="300" height="800" alt="user_list" src="https://github.com/user-attachments/assets/b7257c19-70aa-40b6-a195-bd91ff877c81" />



### Detail Screen

<img width="300" height="800" alt="user_details" src="https://github.com/user-attachments/assets/d63cc46b-54a7-4e31-a7c5-495db244563e" />


---

## Video Demo


https://github.com/user-attachments/assets/e3c136d8-37be-458d-b328-f70fb40e319c


