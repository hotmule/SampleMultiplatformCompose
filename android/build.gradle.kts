plugins {
    id("org.jetbrains.compose") version "0.4.0-build173"
    id("com.android.application")
    kotlin("android")
}

group = "ru.hotmule"
version = "1.0"

repositories {
    google()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.3.0-alpha04")
    implementation("dev.chrisbanes.accompanist:accompanist-insets:0.6.1")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "ru.hotmule.sample_multiplatform_compose"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}