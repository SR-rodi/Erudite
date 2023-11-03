plugins {
    id(Plugin.application)
    id(Plugin.kotlin)
}

android {
    namespace = "ru.sr.erudite"
    compileSdk = Config.compileSdk

    defaultConfig {

        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersions
        targetCompatibility = Config.javaVersions
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    connect(EruditeProjects.UiKit)
    connect(EruditeProjects.Navigation)
    connect(EruditeProjects.FeatureAuth)


    core()
    compose()
    navigation()
}