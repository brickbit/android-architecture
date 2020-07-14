plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.androidExtensions)
    kotlin(Plugins.kotlinKapt)
    id(Plugins.realm)
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

    implementation ("com.android.support:appcompat-v7:27.1.1")
    implementation ("com.android.support:design:27.1.1")
    implementation ("com.android.support:cardview-v7:27.1.1")
    implementation ("com.android.support.constraint:constraint-layout:1.1.3")

    implementation (Libraries.glide)

    implementation (Libraries.kodein)
    implementation (Libraries.kodeinAndroid)

    implementation (Libraries.rxjava)
    implementation (Libraries.rxandroid)

    testImplementation (Libraries.jUnit)
    testImplementation (Libraries.mockito)
    androidTestImplementation (Libraries.mockitoAndroid)
    androidTestImplementation (Libraries.testRunner)
    androidTestImplementation (Libraries.espresso)

    implementation (project(":domain"))
    implementation (project(":data"))
}
