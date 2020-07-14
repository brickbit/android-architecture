const val kotlinVersion = "1.3.71"

object Build {
    object Versions {
        const val buildToolsVersion = "4.0.0"
        const val googleServicesVersion = "4.2.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val googleServicesPlugin = "com.google.gms:google-services:${Versions.googleServicesVersion}"//FIXME
}

object Plugins{
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val androidLibrary = "com.android.library"
    const val androidExtensions = "android.extensions"
    const val kotlinKapt = "kapt"
    const val kotlin = "kotlin"
    const val javaLibrary = "java-library"
    const val googleServices = "com.google.gms.google-services"//FIXME
}
object AndroidSdk {
    const val min = 17
    const val compile = 28
    const val target = compile
    const val applicationId = "com.admin.monuments"
    const val versionName = "20200612"
    const val versionCode = 1
    const val instrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
}

object Libraries {
    private object Versions {
        const val appCompat = "27.1.1"
        const val cardView = "27.1.1"
        const val constraintLayout = "1.1.3"
        const val glide = "4.9.0"
        const val kodein = "4.1.0"
        const val kodeinAndroid = "4.1.0"

        const val retrofit = "2.6.0"
        const val gson = "2.3.0"
        const val okHttp = "3.9.1"
        const val okHttpInterceptor = "3.9.1"

        const val jUnit = "4.13"
        const val mockito = "2.28.2"
        const val mockitoAndroid = "2.28.2"
        const val testRunner = "1.0.2"
        const val espresso = "3.0.2"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardView}"

    const val glide = ("com.github.bumptech.glide:glide:${Versions.glide}")
    const val kodein = ("com.github.salomonbrys.kodein:kodein:${Versions.kodein}")
    const val kodeinAndroid = ("com.github.salomonbrys.kodein:kodein-android:${Versions.kodeinAndroid}")

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpInterceptor}"

    const val jUnit ="junit:junit:${Versions.jUnit}"
    const val mockito ="org.mockito:mockito-inline:${Versions.mockito}"
    const val mockitoAndroid ="org.mockito:mockito-android:${Versions.mockitoAndroid}"
    const val testRunner ="com.android.support.test:runner:${Versions.testRunner}"
    const val espresso ="com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}