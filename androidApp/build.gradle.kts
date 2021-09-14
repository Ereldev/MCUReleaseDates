import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.ereldev.mcureleasedates.android"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    // UI
    implementation("com.google.android.material:material:1.4.0")

    // Compose
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.material:material:1.0.1")
    implementation("androidx.compose.ui:ui-tooling:1.0.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha06")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

    // Image Loading
    implementation("com.github.skydoves:landscapist-coil:1.3.4")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:4.1.0")

    // DI
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.1")

}
