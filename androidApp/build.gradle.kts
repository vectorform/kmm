plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    buildFeatures {
        viewBinding = true
    }
    defaultConfig {
        applicationId = "com.vectorform.kmmshared.android"
        minSdk = 25
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-native-mt")
}