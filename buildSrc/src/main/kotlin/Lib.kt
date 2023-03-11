object Lib {

    object Version {
        internal const val sqldelight = "1.5.4"
        internal const val kotlinxDatetime = "0.4.0"

        object Android {
            const val composeUi = "1.3.0"
            internal const val composeActivity = "1.6.1"
            internal const val composeNavigation = "2.5.3"
            internal const val hilt = "2.44"
            internal const val hiltNaviCompiler = "1.0.0"
            internal const val desugar = "1.1.5"
        }
    }

    object Library {
        const val sqldelight = "com.squareup.sqldelight:runtime:${Version.sqldelight}"
        const val kotlinDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.kotlinxDatetime}"

        object Android {
            const val sqldelightAndroidDriver = "com.squareup.sqldelight:android-driver:${Version.sqldelight}"

            const val composeUi = "androidx.compose.ui:ui:${Version.Android.composeUi}"
            const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.Android.composeUi}"
            const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.Android.composeUi}"
            const val composeFoundation = "androidx.compose.foundation:foundation:${Version.Android.composeUi}"
            const val composeMaterial = "androidx.compose.material:material:${Version.Android.composeUi}"
            const val composeActivity = "androidx.activity:activity-compose:${Version.Android.composeActivity}"
            const val composeNavigation = "androidx.navigation:navigation-compose:${Version.Android.composeNavigation}"

            const val hilt = "com.google.dagger:hilt-android:${Version.Android.hilt}"
            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Version.Android.hiltNaviCompiler}"

            const val desugar = "com.android.tools:desugar_jdk_libs:${Version.Android.desugar}"
        }

        object iOS {
            const val sqldelightNativeDriver = "com.squareup.sqldelight:native-driver:${Version.sqldelight}"
        }
    }

    object Compiler {
        const val daggerHilt = "com.google.dagger:hilt-android-compiler:${Version.Android.hilt}"
        const val hilt = "androidx.hilt:hilt-compiler:${Version.Android.hiltNaviCompiler}"
    }
}