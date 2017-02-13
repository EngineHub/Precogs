Precogs [![Build Status](https://travis-ci.org/me4502/Precogs.svg?branch=master)](https://travis-ci.org/me4502/Precogs)
=======

An AntiCheat service and API built for Sponge.
## Features
* Extensible system for plugins to disable detections temporarily.
* Ability for plugins to log and retrieve user violation level.

## Prerequisites
* [Java] 8
* Sponge

## Building
__Note:__ If you do not have [Gradle] installed then use ./gradlew for Unix systems or Git Bash and gradlew.bat for Windows systems in place of any 'gradle' command.

In order to build Precogs you simply need to run the `gradle build` command. You can find the compiled JAR file in `./build/libs` labeled similarly
 to 'Precogs-x.x-SNAPSHOT.jar'.

## Plugins using Precogs
* Guardian

Have a plugin using Precogs? Contact me and I'll add it.