plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = ProjectSetting.PACKAGE_NAME
    compileSdk = 34

    defaultConfig {
        applicationId = ProjectSetting.PACKAGE_NAME
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        buildConfig = true
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.7.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")

    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    implementation("androidx.room:room-runtime:${DepGradleVersion.room}")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:${DepGradleVersion.room}")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:${DepGradleVersion.room}")

    implementation("androidx.datastore:datastore-preferences:${DepGradleVersion.preferences_version}")

    // Glide
    implementation("com.github.bumptech.glide:glide:${DepGradleVersion.glide}")

    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:retrofit:${DepGradleVersion.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${DepGradleVersion.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${DepGradleVersion.logging_interceptor}")

    implementation("com.google.dagger:hilt-android:${DepGradleVersion.dagger_hilt}")

    kapt("com.google.dagger:hilt-android-compiler:${DepGradleVersion.dagger_hilt}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${DepGradleVersion.coroutine}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${DepGradleVersion.coroutine}")


    debugImplementation("com.github.chuckerteam.chucker:library:${DepGradleVersion.chucker}")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:${DepGradleVersion.chucker}")


    kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.7.0")
    implementation("androidx.lifecycle:lifecycle-service:2.7.0")
    implementation("androidx.lifecycle:lifecycle-process:2.7.0")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.7.0")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:2.7.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}