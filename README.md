# hackathonapp

HackathonApp is the first internal event about programming and technology organized by employees of the Mobile Media and Communication Lab. Instead of traditional Power point presentations the whole event will be available in Github. 

First speaker: César Izquierdo
In the first part of the hackathon I am going to present Android development with Android Studio. In this first event the intentation is introduce the main concepts of Android development, some best practices, usefull tools using Android Studio as IDE of development and during the presentation we will build an app called: HackathonApp.
The idea of the presentation is create the "ultra known" Helloo World app and modify it introducing more Android development concepts until to realease the first version of our HackathonApp.

Presentation 

# v.1.0 of the Hackathon app

1. Important concepts to know before to create our Hello World!! first app:

  - compiledSdkVersion: is the platform version against which you will compile the app. By default is the last one, this is           convenient to have always the latest features.
  - applicationId: fully quialified package name.
  - minSdkVersion: the earliest version that your app supports.
  - targetSdkVersion: the highest version with wich you have tested your app.
  
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

2. We open Android Studio and we go to File > New Project

   A naming convention rule for naming convention is: 
   
    com.[company_domain_name].[app_name] -> com.m2clabthon.hackathonapp 
    
   The reason to follow this convention is to do with in sychronization with the lyout on the storage media and all applications from this [company_domain_name] publisher would sit together in the path hierarchy
   
   For instance:
   
    com.m2clabthon.hackathonapp (m2cLabthon HackathonApp)
    com.m2clabthon.birthdayapp (m2cLabthon BirthdayApp)
    
Resource: http://stackoverflow.com/questions/6273892/android-package-name-convention
    
  In wizard of Android Studio to create a new project, we will fill two fields to follow this convention: 
  
      Application name: First letter in capital of each word (Android will convert to lower letter for the package name)
      Company Domain: revers order of the package.
      
 3. Once the project in created, Android Studio provide some projects views in the navigation project sidebar interestings depends what you want to focus:
    
   - Android:  is the flatterned version of the project structure and it provides a quick acces to the key source files of Android projects. Furthermote is very useful when we create drawables in different resolutions, because in this view we will see only one with a number that identify how many resolutions we created for this concrete resource.
   - Project: Java development perspective
   - Packages: focus on organization of the packages.
  
We can an also change the view depends of the scope:
   
   - Project files.
   - Problems
   - Production
   - Test 

4. Basic structure folders
   
  - app -> src -> main -> java: java files of the app. Logic and models = CONTROLLERS + MODELS
  - app -> src -> main -> res: resources of the app
            - drawable-(different resolutions): images and graphics.
            - layout: dynamic XML visual interfaces. VIEWS
            - menu: menus of the app
            - values: files for theming the app. Dimensions (paddings, margins, etc), strings of the app (for translations and abstraction), styles (general theming for supported version)
  - AndroidManifest.xml -> general configuration of the project. We should add here which Activities we are going to use in the app, which theming we are using, add permissions that our app could need. 
  - app -> src -> build.gradle -> gradle file we we can do changes in the build configuration of the app.

5. Android is MVC framework. 

  - The next step in our app is create a Speaker java file that it will present a speaker in the hackathon. The Speaker will be define by a unique UUID id and a name. We will create a package call com.m2clabthon.hackathonapp.model where we will place all the models of the app.
  
  - If we follow the Android developers convention to name the mutable private variables like: 
  
     private UUID mId;
     private String mName; 
   
  and we create automatically the contructor and getters and setters. We realize that the name of the setter and getter will follow the convention set[private_variable], Android Studio generate in wrong way the setters/getters. But is possible to change that in Settings.

  - We analize the method onCreate of the MainActivity. Each Activity should override the method onCreate. The onCreate method is the method where we should init all our class variables, get the references of our Views objects and load the model.
      
    We want that our onCreate of our app loads the Speaker model with some speaker and should [NameOfSpeaker] says [RandomText] instead of the static Hello World!. We have to add some logic in onCreate: 
  
    - Loading the model.
    - Create a string resource that contains "says"
    - Create a string-array resource that contains some random quotes of the speaker
    - Create a Resources object to retrieve the value two string elements previously create
    - Modify the layout to add a id to the textView where we want to place the dynamic text
    - Set the TextView with the name of the speaker (get from the model) + "says" (from the string) + one of
    the string quotes of the array

  Notice that each time that we press the home button and the app go and back from the background the random text is different. Why? Because the lifecycle that we will see later.
  
  Now our app is Model View Controller because:
  
  (Model) Speaker <-------- (get data) ---- MainActivity -----(modify)------>  View
  
6. Some patterns to organize the projects (each developer organize their files as he wants, but some followed suggestions): 
  
   - models
   - fragments
   - utils
   - taks - network or both
   - global
   - adapters
   - notifications (under views/widgets, but I prefer not do a lot of nested packages)
  
   Naming conventions.
     Convention for the name of the layouts: type_foo_bar.xml -> for instance, fragment_contact_details.xml. Then the java fragment is called (controller) ContactDetaulsFragment.java

   One of the best links of best practices that I found: 
   
     https://github.com/futurice/android-best-practices

7. Lifecycle of Android Activities. 

   Look at: http://developer.android.com/reference/android/app/Activity.html
   We implemeted some logs in the different methods of the lifecycle and we debbug the app to see what happend.
   
8. Abstracting the styles. We want to create our basic theming but we want that our theming flexible to reuse across the app.

   Create our theme customization in style.xml changing the color of the action bar
   Create a color.xml with main colors of the app
   We see how is used the dimens.xml out activity_main.xml
   We see how to translate the strings of the app and how to do it.
   
# v.1.1 of the Hackathon app

 9. In this new version we want -> Now we going to improve the functionality. When we open the app we want to see a list of speakers. When we click in one of the speakers of the list the app will go through another activity and we will see the meesage of the last version (Speaker name) + "says" + randoms string.
 
 10. Doing in the most simplistic way we:
      
      - Rename MainActivity and called -> HackathonTalkActivity that it will show the speaker and the quote.
      - Create a new Activity called -> HackathonEventActivity that it will contains the list of the Speakers.
      - How to have the list of speakers load at the beginning and across the app. Singleton pattern to centralize the storage is one possible solution. In this singleton patter we will add an ArrayList of Speakers.
      - Create an Adapter to load the list
      - Listener to add the logic of the Controller and call to the next Activity.
      - How to call to HackathonEventActivity to HackathonTalkActivity and show the correct Speaker? Using Intents and extra parameters to pass data
      - 
 The app now do more things and it is able to communicate with other elements. We keep the model - view - controller pattern. But the UI it´s not flexible. The Activities are standalone objects without the possibility to reuse. Moreover, it is very hard to adapt to different screen support. How to increase the flexibility of the UI? More abstractions, using Fragments. 

# v.1.2 of Hackathon app

 11. Fragments. What is it? and Lifecycle
    
     Fragments represents a portion of user interface on the activity. You can combine different fragments in the same activity, replace, switch or delete them in runtime. You can thing a fragment as embed peace of behaviour with their own interface. Because is a independent portion of the app, you can reuse whathever you want. 

     More info in: http://developer.android.com/guide/components/fragments.html
     
 12. In this last version we integrate fragments in the app, we will do the following modifications:
     
     - Create a Abstract activity to add the fragment that we need in each Activity with the same code.
     - Create a abstract layout same for both Activities that will embed the fragments.
     - Create a ListFragment for the list of speackers
     - Create a Fragment for the quote of the speaker
     - Load Fragment of the speaker with the parameter of the Intent.
  

In next evets....

   - AsyncTasks
   - Background processes
   - GeoLocation services and Maps

Bunch of resources

Android Arsenal https://android-arsenal.com/
Best practices of Android development https://github.com/futurice/android-best-practices
Create graphs in Android http://stackoverflow.com/questions/9741300/charts-for-android
Material Design icons http://materialdesignicons.com/
Google I/O 2014 Android app https://github.com/google/iosched
AsyncTask in Fragments best practices http://www.michenux.net/android-asynctask-in-fragment-best-pratices-725.html
Android Testing https://speakerdeck.com/f2prateek/android-testing
Cloud Tools for Android Studio https://cloud.google.com/mobile/
Android Studio Tips and Tricks http://www.donnfelker.com/android-studio-tips-and-tricks-part-1/
Java Client for Google Maps Services https://github.com/googlemaps/google-maps-services-java/
Java design Patterns https://github.com/iluwatar/java-design-patterns
