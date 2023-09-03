buildscript {
    dependencies {
        classpath(ProjectConfig.ClassPath.kotlinGradle)
        classpath(ProjectConfig.ClassPath.androidGradle)
        classpath(ProjectConfig.ClassPath.hilt)
    }
}

plugins {
    id(Plugin.androidApplication).version(Plugin.Version.application).apply(false)
    id(Plugin.androidLibrary).version(Plugin.Version.library).apply(false)
    id(Plugin.realm).version(Plugin.Version.realm).apply(false)
    kotlin(Plugin.android).version(ProjectConfig.Version.kotlin).apply(false)
    kotlin(Plugin.multiplatform).version(ProjectConfig.Version.multiplatform).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}