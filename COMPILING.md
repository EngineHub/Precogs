Compiling
=========

You can compile Precogs as long as you have the [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html) for Java 8 or newer.
You only need one version of the JDK installed.

The build process uses Gradle, which you do *not* need to download. Precogs is a multi-module project with three modules:

* `precogs-core` contains the Precogs API
* `precogs-bukkit` is the Bukkit plugin
* `precogs-sponge` is the Sponge plugin

## To compile...

### On Windows

1. Shift + right click the folder with Precogs's files and click "Open command prompt".
2. `gradlew build`

### On Linux, BSD, or Mac OS X

1. In your terminal, navigate to the folder with Precogs's files (`cd /folder/of/precogs/files`)
2. `./gradlew build`

## Then you will find...

You will find:

* The core Precogs API in **precogs-core/build/libs**
* Precogs for Bukkit in **precogs-bukkit/build/libs**
* Precogs for Sponge in **precogs-sponge/build/libs**

If you want to use Precogs, use the `-dist` version.

(The -dist version includes Precogs + necessary libraries.)

## Other commands

* `gradlew idea` will generate an [IntelliJ IDEA](http://www.jetbrains.com/idea/) module for each folder.
* `gradlew eclipse` will generate an [Eclipse](https://www.eclipse.org/downloads/) project for each folder.
