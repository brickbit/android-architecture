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
        mavenCentral()
        maven (url = "https://oss.sonatype.org/content/repositories/snapshots" )
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
