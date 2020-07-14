plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.androidExtensions)
    kotlin(Plugins.kotlinKapt)
}


android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = AndroidSdk.applicationId
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = AndroidSdk.instrumentationRunner
    }
    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include"  to listOf("*.jar"))))
    implementation (Libraries.kotlinStdLib)

    implementation ("androidx.appcompat:appcompat:1.0.0")
    implementation ("com.google.android.material:material:1.0.0")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation (Libraries.glide)

    implementation (Libraries.kodein)
    implementation (Libraries.kodeinAndroid)

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.2.1")

    testImplementation (Libraries.jUnit)
    testImplementation (Libraries.mockito)
    androidTestImplementation (Libraries.mockitoAndroid)
    androidTestImplementation (Libraries.testRunner)
    androidTestImplementation (Libraries.espresso)

    implementation (project(":domain"))
    implementation (project(":data"))
}
