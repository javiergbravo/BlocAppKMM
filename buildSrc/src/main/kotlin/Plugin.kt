object Plugin {

    const val multiplatform = "multiplatform"
    const val android = "android"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kapt = "org.jetbrains.kotlin.kapt"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val realm = "io.realm.kotlin"

    object Version {
        internal const val android = "7.3.1"
        const val application = android
        const val library = android
        const val realm = "1.11.0"
    }
}