plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
    id(Plugin.realm)
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Lib.Version.Android.composeCompiler
    }
    packaging {
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

tasks.withType(type = org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask::class) {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()

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

    implementation(Lib.Library.koin)
    implementation(Lib.Library.Android.koin)
    implementation(Lib.Library.Android.koinCompose)

    implementation(Lib.Library.realm)
    compileOnly(Lib.Library.realm)

    implementation(Lib.Library.kotlinDatetime)
}