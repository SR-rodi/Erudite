import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Config {
    val compileSdk = 34

    val applicationId = "ru.sr.erudite"
    val minSdk = 26
    val targetSdk = 34
    val versionCode = 1
    val versionName = "1.0"
    val javaVersions = JavaVersion.VERSION_17
    val jvmTarget = "17"
    val kotlinCompilerExtensionVersion = "1.5.3"
}
