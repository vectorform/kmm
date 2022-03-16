Vectorform KMM Example

**androidApp** - An Android Application. You can open this folder in Android Studio and run it as you would any Android Studio project.

**iosApp** - An iOS applocation. You can open this filder in Xcode and run it as you would any Xcode project.

**shared** - The shared code for both iOS and Android resides here. Use commonMain for code that each platform can share. Use the respective platform
directories for any platform specific code.

The gradle.kts file in the **shared** directory is the one you will use for publishing frameworks and .aars.

For cocoapods, modify the shared.podspec file in **root**. Once you commit to git, tag the release and make sure it matches your podspec version.