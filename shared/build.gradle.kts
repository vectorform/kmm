plugins {
    id("com.android.library")
    id("maven-publish")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

val kmmVersion = "0.0.1"
version = kmmVersion

// run .gradlew assemble to create the libraries for each platform
// for iOS - update your podspec and tag your release in git
// for android - run .gradle publish making sure you modify your groupId, artifactId, and version number

// multiplatform
kotlin {

    android {
        publishLibraryVariants("release", "debug")
        publishLibraryVariantsGroupedByFlavor = true
    }

    iosX64 {
        binaries.framework {
            baseName = "iOSX-shared"
        }
    }
    iosArm64 {
        binaries.framework {
            baseName = "iOSArm-shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:1.6.7")
                implementation("io.ktor:ktor-client-serialization:1.6.7")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("io.ktor:ktor-client-android:1.6.7")
                implementation("io.ktor:ktor-utils-jvm:1.6.7")
                implementation("io.ktor:ktor-client-core-jvm:1.6.7")
                implementation("io.ktor:ktor-client-okhttp:1.6.7")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.7")
            }
        }
    }
}

// android app
android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 25
        targetSdk = 31
    }
}

// maven publishing
publishing {
    publications {
        create<MavenPublication>("aar") {
            groupId = "com.company.group"
            artifactId = "project"
            version = kmmVersion

            artifact("$buildDir/outputs/aar/shared-release.aar")

            pom.withXml {
                val dependenciesNode = asNode().appendNode("dependencies")
                fun addDependency(dep: Dependency, scope: String) {
                    if (dep.group == null || dep.version == null || dep.name.isEmpty() || dep.name == "unspecified")
                        return
                    val dependencyNode = dependenciesNode.appendNode("dependency")
                    dependencyNode.appendNode("groupId", dep.group)
                    dependencyNode.appendNode("artifactId", dep.name)
                    dependencyNode.appendNode("version", dep.version)
                    dependencyNode.appendNode("scope", scope)
                }
                configurations.api.get().allDependencies.forEach {
                    addDependency(it, "compile")
                }
                configurations.implementation.get().allDependencies.forEach {
                    addDependency(it, "runtime")
                }
            }
        }

        repositories {
            maven {
                // these properties are from gradle.properties (Global Properties)
                url = uri(findProperty("VF_MAVEN_REPO").toString())
                credentials {
                    username = findProperty("VF_MAVEN_USERNAME").toString()
                    password = findProperty("VF_MAVEN_PASSWORD").toString()
                }
            }
        }
    }
}