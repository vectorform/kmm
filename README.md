# Vectorform Kotlin Multiplatform Mobile (KMM) Example

This is a small example of using KMM using KTOR and a jokes API. This example does not demonstrate expect/actual classes that some projects may prefer to use for platform specific implementations.

# Setup
local.properties
```sdk.dir=/Location/Of/Your/Android/sdk```
e.g. ```/Users/yourUserName/Library/Android/sdk```

gradle.properties

# Shared
The shared code for both iOS and Android is located in the shared directory. Use commonMain for code that each platform can share. Use the respective platform directories for any platform specific code.

```Kotlin
class JokeAPI {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getJoke(): Joke {
        val url = BASE_URL
        val result = client.get<String>(url)
        return Json.decodeFromString(result)
    }

    companion object {
        private const val BASE_URL = "https://v2.jokeapi.dev/joke/Any?safe-mode"
    }
}
```

# Android App
The Android application is located inside the **androidApp** directory. You can open this folder in Android Studio and run it as you would any Android Studio project.

```Kotlin
suspend fun getJoke() {
    try {
        setContentString("getting joke...")
        val jokeAPI = JokeAPI()
        val joke = jokeAPI.getJoke()
        withContext(Dispatchers.Main) { setContentString(joke.toString()) }
    } catch (exception: Exception) {
        withContext(Dispatchers.Main) { handleException(exception) }
    }
}
```

# iOS App
The iOS application is located inside the **iosApp** directory. You can open this folder in Xcode and run it as you would any Xcode project.

KMM generates the shared functions in iOS with a completion handler, or you can use the async function if your app's iOS version supports it.

```swift
func getJoke() {
    let jokeAPI: JokeAPI = JokeAPI()
    resultLabel.text = "getting joke..."
    jokeAPI.getJoke { [weak self] joke, error in
        self?.resultLabel.text = joke?.debugDescription
    }
}
```

# Gradle
The gradle.kts file in the **shared** directory is the gradle file you should use for publishing frameworks and .aars.

# Cocoapods
For cocoapods, modify the shared.podspec file in **root**. After you commit, be sure to tag the release making sure it matches your podspec version.

## License
[MIT](https://choosealicense.com/licenses/mit/)
