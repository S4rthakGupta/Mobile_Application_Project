plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.productapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.productapp"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview) // Add RecyclerView
    implementation(libs.cardview) // Add CardView
    implementation(libs.room.runtime) // Add Room Runtime
    annotationProcessor(libs.room.compiler) // Add Room Compiler
    implementation(libs.picasso) // Add Picasso
    implementation "androidx.room:room-runtime:2.5.0"
    annotationProcessor "androidx.room:room-compiler:2.5.0" // For Java

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}