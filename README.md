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
    * `src/main/java/edu/augustana/csc305/lab4`: the Java source
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


## Switching to JSON

The rest of the lab will look at using JSON to serialize students instead of 
`Serializable` object streams. We will use GSON to serialize and deserialize
JSON strings. (You can verify GSON is included as a project dependency in
`pom.xml`.)

To start, create a new class in the `serialization` package called `JsonSaver`
which implements `StudentSaver`. In `RegistrationController`, change the
`studentSaver` initialization to use `JsonSaver` instead of `SerializableSaver`.

### Implementing `saveStudents`

To implement `saveStudents(...)`, we will first convert our list of `Student`s to
a JSON string. Create a new `Gson` object and call its `toJson(...)` method,
passing in our list of `Student`s. Store the result in a `String` called `json`.
(You can temporarily print this string to the console if you want to verify
it is getting generated correctly before continuing.)

After you have your `json` string, write it out to the `loadPath` given as a
method parameter. The easiest way to accomplish this is with a `PrintWriter`:

```java
try (PrintWriter out = new PrintWriter(savePath)) {
    out.println(json);
}
```

Try adding several students and saving the file to disk. If you open the file you
saved, you should see human-readable JSON containing the student information. Compare
this to a file written using the `SerializableSaver`, which is not human-readable.

### Implementing `loadStudents`

To implement `loadStudents`, again use a `Gson` object, but this time call `fromJson(...)`.

You will need to pass the `fromJson` method two arguments: a reader to provide the JSON and the
type to deserialize into. For the former argument, create a `new FileReader(loadPath)`.
For the latter argument, we have a couple of options. One is to create a GSON `TypeToken`
representing an `ArrayList` of students. The other is to deserialize into a `Student[]`
and convert that to an `ArrayList`. We will use the second option:

1. Pass `Student[].class` as the second argument to `fromJson`. Store the result of the
   `fromJson` call as a `Student[]` called `students`.
2. Convert the students array into an `ArrayList` using the `Arrays` utility class:
   `Arrays.asList(students)`. Return this `ArrayList`.

### Test

You should now be able to serialize and deserialize students to disk using JSON. Test this
by adding students, saving the students, clearing the student list, then reloading your
students from disk. Make sure you have remembered to switch `RegistrationController` to 
use `JsonSaver`!

## Submission Instructions

When you are finished, upload your `JsonSaver.java` file to Moodle.