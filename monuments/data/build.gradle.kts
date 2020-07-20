plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
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

    implementation (Libraries.retrofit)
    implementation (Libraries.gson)
    implementation (Libraries.okHttp)
    implementation (Libraries.okHttpInterceptor)

    implementation (Libraries.coroutines)
    implementation (Libraries.retrofitAdapter)

    implementation ("androidx.room:room-runtime:2.2.5")
    kapt ("androidx.room:room-compiler:2.2.5")
    implementation ("androidx.room:room-ktx:2.2.5")

    testImplementation (Libraries.jUnit)
    testImplementation (Libraries.mockito)

    implementation (project(":domain"))
}