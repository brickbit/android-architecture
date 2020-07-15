plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlin)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include"  to listOf("*.jar"))))
    implementation (Libraries.kotlinStdLib)

    testImplementation (Libraries.jUnit)
}

