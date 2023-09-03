import org.gradle.kotlin.dsl.accessors.AccessorFormats.internal

object Lib {

    object Version {
        internal const val realm = Plugin.Version.realm
        internal const val kotlinxDatetime = "0.4.0"
        internal const val koin = "3.4.3"

        object Android {
            const val composeUi = "1.5.0"
            internal const val composeActivity = "1.6.1"
            internal const val composeNavigation = "2.5.3"
            internal const val desugar = "1.1.5"

            const val composeCompiler = "1.5.3"
        }
    }

    object Library {
        const val realm = "io.realm.kotlin:library-base:${Version.realm}"
        const val kotlinDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.kotlinxDatetime}"
        const val koin = "io.insert-koin:koin-core:${Version.koin}"

        object Android {

            const val composeUi = "androidx.compose.ui:ui:${Version.Android.composeUi}"
            const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.Android.composeUi}"
            const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.Android.composeUi}"
            const val composeFoundation = "androidx.compose.foundation:foundation:${Version.Android.composeUi}"
            const val composeMaterial = "androidx.compose.material:material:${Version.Android.composeUi}"
            const val composeActivity = "androidx.activity:activity-compose:${Version.Android.composeActivity}"
            const val composeNavigation = "androidx.navigation:navigation-compose:${Version.Android.composeNavigation}"

            const val koin = "io.insert-koin:koin-android:${Version.koin}"
            const val koinCompose = "io.insert-koin:koin-androidx-compose:${Version.koin}"

            const val desugar = "com.android.tools:desugar_jdk_libs:${Version.Android.desugar}"
        }

        object iOS {}
    }
}