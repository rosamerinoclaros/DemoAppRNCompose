
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.facebook.react")
}

android {
    namespace = "com.example.rn_compose_incompatibility"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rn_compose_incompatibility"
        minSdk = 24
        targetSdk = 34
        buildToolsVersion = "35.0.0"
        ndkVersion = "27.1.12297006"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources.excludes.add("**/libjscexecutor.so")
        resources.pickFirsts.apply {
            add("**/armeabi-v7a/libc++_shared.so")
            add("**/x86/libc++_shared.so")
            add("**/arm64-v8a/libc++_shared.so")
            add("**/x86_64/libc++_shared.so")
            add("**/x86/libjsc.so")
            add("**/armeabi-v7a/libjsc.so")
            add("META-INF/AL2.0")
            add("META-INF/**.kotlin_module") // Usercentrics Kotlin modules
        }
        jniLibs.useLegacyPackaging = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.react.android)
    implementation(libs.hermes.android)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

react {
    autolinkLibrariesWithApp()
}