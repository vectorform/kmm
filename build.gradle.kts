plugins {
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.10"
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.0.4")
    }
}

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        }
    }
}