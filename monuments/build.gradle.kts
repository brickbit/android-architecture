buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath (Build.androidGradlePlugin)
        classpath (Build.kotlinGradlePlugin)
        classpath (Build.realmGradlePlugin)

    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
