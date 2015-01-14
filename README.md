# hackathonapp

HackathonApp is the first internal event about programming and technology organized by employees of the Mobile Media and Communication Lab. Instead of traditional Power point presentations the whole event will be available in Github. 

First speaker: César Izquierdo
In the first part of the hackathon I am going to present Android development with Android Studio. In this first event the intentation is introduce the main concepts of Android development, some best practices, usefull tools using Android Studio as IDE of development and during the presentation we will build an app called: HackathonApp.
The idea of the presentation is create the "ultra known" Helloo World app and modify it introducing more Android development concepts until to realease the first version of our HackathonApp.

Presentation 

1. Important concepts to know before to create our Hello World!! first app:

  - compiledSdkVersion: is the platform version against which you will compile the app. By default is the last one, this is           convenient to have always the latest features.
  - applicationId: fully quialified package name.
  - minSdkVersion: the earliest version that your app supports.
  - targetSdkVersion: the highest version with wich you have tested your app. 
  - 
More information: http://developer.android.com/training/basics/firstapp/creating-project.html

In Android project everything is built by Gradle. 

Gradle is a new build system. The main goals of Gradle are: 

  - Make it easy to reuse code and resources
  - Make it easy to create several variants of an application, either for multi-apk distribution or for different flavors of an application
  - Make it easy to configure, extend and customize the build process
  - Good IDE integration

Some of Gradle features:

  - Domain Specific Language (DSL) to describe and manipulate the build logic
  - Build files are Groovy based and allow mixing of declarative elements through the DSL and using code to manipulate the     - DSL elements to provide custom logic.
  - Built-in dependency management through Maven and/or Ivy.
  - Very flexible. Allows using best practices but doesn’t force its own way of doing things.
  - Plugins can expose their own DSL and their own API for build files to use.
  - Good Tooling API allowing IDE integration 
  
Good start point in: http://tools.android.com/tech-docs/new-build-system/user-guide

2. Onces our Hello World app is created 
  
