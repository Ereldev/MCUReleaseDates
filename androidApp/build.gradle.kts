plugins {
    id("com.android.application")
    kotlin("android")
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
    //TODO can be removed ?
    implementation("androidx.appcompat:appcompat:1.3.1")

    // Compose
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.material:material:1.0.1")
    implementation("androidx.compose.ui:ui-tooling:1.0.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.1")

}