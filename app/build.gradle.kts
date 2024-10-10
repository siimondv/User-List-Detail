plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}



android {
    namespace = "com.example.listdetail"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.listdetail"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://api.github.com/repos/android/compose-samples/\"")
    }


    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api.github.com/repos/android/compose-samples/\""
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
        buildConfig = true  // Enable BuildConfig generation
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.viewbinding)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)


    // sdp
    implementation(libs.sdp.android)
    // ssp
    implementation(libs.ssp.android)


    // glide
    implementation(libs.glide)

    // toasty
    implementation(libs.toasty)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx.v260)
    implementation(libs.androidx.navigation.ui.ktx.v260)


}