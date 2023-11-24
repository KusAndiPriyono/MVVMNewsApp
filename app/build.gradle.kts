import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.bangkit.mvvmnewsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bangkit.mvvmnewsapp"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        val localPropertiesFile = project.rootProject.file("local.properties")
        val input = localPropertiesFile.inputStream()
        properties.load(input)
        val apiKey = properties.getProperty("API_KEY")
        val baseURL = properties.getProperty("BASE_URL")
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
        buildConfigField("String", "BASE_URL", "\"$baseURL\"")
        input.close()
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    val lifecycle_version = "2.6.2"
    val dagger_hilt_version = "2.48"
    val navigation_version = "2.7.5"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    //Dagger & Hilt
    implementation("com.google.dagger:hilt-android:$dagger_hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$dagger_hilt_version")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")


    //testImplementation
    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    testImplementation("com.google.truth:truth:1.1.3")


}

kapt {
    correctErrorTypes = true
}