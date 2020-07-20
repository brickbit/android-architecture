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

    implementation (Libraries.appCompat)
    implementation (Libraries.material)
    implementation (Libraries.cardview)
    implementation (Libraries.constraintLayout)

    implementation (Libraries.glide)

    implementation (Libraries.kodein)
    implementation (Libraries.kodeinAndroid)

    implementation (Libraries.coroutines)
    implementation (Libraries.coroutinesAndroid)

    implementation ("androidx.room:room-runtime:2.2.5")
    kapt ("androidx.room:room-compiler:2.2.5")
    implementation ("androidx.room:room-ktx:2.2.5")

    testImplementation (Libraries.jUnit)
    testImplementation (Libraries.mockito)
    androidTestImplementation (Libraries.mockitoAndroid)
    androidTestImplementation (Libraries.testRunner)
    androidTestImplementation (Libraries.espresso)

    implementation (project(":domain"))
    implementation (project(":data"))
}
