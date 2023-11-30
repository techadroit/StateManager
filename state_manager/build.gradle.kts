plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
}

android {

    val minSdkVersion = 24
    val targetSdkVersion = 33
    val compileSdkVersion = 33
    val buildToolVersion = "30.0.3"

    namespace = "com.state_manager"

    compileSdk = compileSdkVersion
    buildToolsVersion = buildToolVersion

    defaultConfig {
        minSdk = minSdkVersion
        targetSdk = targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        release {

        }
        debug {

        }
    }
}

dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    implementation("app.cash.turbine:turbine:1.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
}
