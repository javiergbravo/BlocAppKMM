plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
    id(Plugin.kapt)
    id(Plugin.daggerHilt)
}

android {
    namespace = ProjectConfig.Android.appId
    compileSdk = ProjectConfig.Android.compileSdk
    defaultConfig {
        applicationId = ProjectConfig.Android.appId
        minSdk = ProjectConfig.Android.minSdk
        targetSdk = ProjectConfig.Android.targetSdk
        versionCode = ProjectConfig.Android.versionCode
        versionName = ProjectConfig.Android.versionName
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Version.Android.composeUi
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":core"))

    implementation(Lib.Library.Android.composeUi)
    implementation(Lib.Library.Android.composeUiTooling)
    implementation(Lib.Library.Android.composeUiToolingPreview)
    implementation(Lib.Library.Android.composeFoundation)
    implementation(Lib.Library.Android.composeMaterial)
    implementation(Lib.Library.Android.composeActivity)
    implementation(Lib.Library.Android.composeNavigation)
    implementation(Lib.Library.Android.hilt)
    implementation(Lib.Library.Android.hiltNavigationCompose)

    implementation(Lib.Library.kotlinDatetime)

    coreLibraryDesugaring(Lib.Library.Android.desugar)

    kapt(Lib.Compiler.daggerHilt)
    kapt(Lib.Compiler.hilt)
}