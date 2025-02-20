pluginManagement {
    includeBuild("../node_modules/@react-native/gradle-plugin")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins { id("com.facebook.react.settings") }
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
extensions.configure(com.facebook.react.ReactSettingsExtension::class.java) {
    autolinkLibrariesFromCommand()
}
includeBuild("../node_modules/@react-native/gradle-plugin")

rootProject.name = "rn-compose-incompatibility"
include(":app")
 