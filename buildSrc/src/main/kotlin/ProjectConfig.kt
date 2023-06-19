object ProjectConfig {

    const val appName = "BlocAppKMM"
    internal const val projectPackage = "blocappkmm"
    internal const val mainPackage = "com.jgbravo"
    const val appPackage = "${mainPackage}.$projectPackage"

    object Android {
        const val appId = "$appPackage.android"
        const val minSdk = 28
        const val targetSdk = 33
        const val compileSdk = targetSdk
        const val versionCode = 1
        const val versionName = "0.0.1"
    }

    object Version {
        const val kotlin = "1.7.10"
        const val multiplatform = kotlin
        internal const val android = "7.2.2"
        internal const val sqlDelight = "1.5.5"
        internal const val hilt = "2.44"
    }


    object ClassPath {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val androidGradle = "com.android.tools.build:gradle:${Version.android}"
        const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${Version.sqlDelight}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    }
}