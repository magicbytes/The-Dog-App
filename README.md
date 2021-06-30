The Dog App
=========================
List            |  Details
:-------------------------:|:-------------------------:
![]<img src="https://user-images.githubusercontent.com/17177542/123901463-e1029f80-d962-11eb-8a1e-117ca62d8b2f.png" width="250" height="500">  |  ![]<img src="https://user-images.githubusercontent.com/17177542/123901470-e2cc6300-d962-11eb-96c4-cea0ca834554.png" width="250" height="500">


An application which illustrates a simplified MVVM architecture for executing a network call and showing
the list of content inside a `RecyclerView`. For implementing the MVVM architecture, it was used JetPack and
recommended best practices

Introduction
------------

Android Jetpack is a set of components, tools and guidance to make great Android apps. They bring
together the existing Support Library and Architecture Components and arrange them into four
categories:

![Android Jetpack](screenshots/jetpack_donut.png "Android Jetpack Components")



Getting Started
---------------
This project uses the Gradle build system. To build this project, use the
`gradlew build` command or use "Import Project" in Android Studio.

There are two Gradle tasks for testing the project:
* `connectedAndroidTest` - for running Espresso on a connected device
* `test` - for running unit tests


Libraries Used
--------------
* [Foundation] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
    * [AppCompat] - Degrade gracefully on older versions of Android.
    * [Android KTX] - Write more concise, idiomatic Kotlin code.
* [Architecture] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
    * [Lifecycles] - Create a UI that automatically responds to lifecycle events.
    * [LiveData] - Build data objects that notify views when the underlying database changes.
    * [ViewModel] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
      asynchronous tasks for optimal execution.
    * [Coroutines] - for background task management
* [UI] - Details on why and how to use UI Components in your apps - together or separate
    * [RecyclerView] - Powerful component for displaying a scrolling list of items based on large data sets.
* Third party
    * [Picasso] for image loading
    * [Retrofit] for network requests
    * [Gson] for serialisation/deserialisation

Upcoming features
-----------------
Updates will include incorporating additional Jetpack components and updating existing components
as the component libraries evolve. In addition, it will be added unit tests and UI tests.
