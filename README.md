# CSC 305 Lab 4

In this lab, we will look at serializing objects to disk. Our goal is
to build a registration application that can save and load registered
students.

To get started, clone this repository and then open the project 
directory (or the pom.xml it contains) in IntellJ Idea. Once you have
opened the project in Idea, follow along with the rest of this README.

## A Tour of the Project

The project structure is similar to that of our previous labs. The project 
directory contains the following:

* `README.md`: this README file.
* `pom.xml`: defines the project's properties and dependencies. The
  main configuration file used by Maven to build, run, and package
  the project.
* `mvnw` and `mvnw.cmd`: wrappers around Maven build commands. A
  standard part of Maven projects that we can ignore for now.
* `src`: the directory where the source code lives.
    * `src/main/java/module-info.java`: a JavaFX configuration file
      describing JavaFX-specific module dependencies and exports.
    * `src/main/java/edu/augustana/csc305/lab3`: the Java source
      files for this lab.

The source files consist of the following:

* `Lab4App`: the main entry point for running the application.
* `Student`: a model class for students.
* A `serialization` package with the classes for reading and writing files.
* A `ui` package which contains a model, views, and a controller for a simple
  student registration UI.

The `serialization` package contains:

* `StudentSaver`: An interface for saving and loading student information
  to and from disk.
* `SerializableSaver`: A `StudentSaver` which uses Java's `Serializable`
  interface for persistence.

Take a moment to familiarize yourself with these classes, especially 
`SerializableSaver` and the button listeners in `RegistrationController`
which handle the mechanics of saving and loading. Note the use of `FileChooser`
in `RegistrationController` for showing save and open dialogs; you may
wish to use this class in your own projects.

Run the application via the `Lab4App` class and verify you see the
registration UI. Try adding students, saving your students to a file,
clearing the list, and loading your students back from the file.


## Switching to GSON

The rest of the lab will look at using GSON to serialize students instead of 
`Serializable`.

To start, create a new class in the `serialization` package called `GsonSaver`
which implements `StudentSaver`.


## Submission Instructions

When you are finished, upload all of your model, view, and controller classes to Moodle.
Place them in a single zip or tar file if you know how to do that, otherwise you may
upload the files individually.