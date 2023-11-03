import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibrirySettingsGradle:Plugin<Project> {
    override fun apply(project: Project) {
        setProjectConfig(project)
    }

    private fun setProjectConfig(project: Project){
        project.android().apply {
            compileSdk = Config.compileSdk
            defaultConfig {
                minSdk = Config.minSdk
            }
            buildFeatures {
                compose = true
            }

            compileOptions   {
                sourceCompatibility = Config.javaVersions
                targetCompatibility  = Config.javaVersions
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
            }
        }
    }

    private fun Project.android(): BaseAppModuleExtension {
      return  extensions.getByType(BaseAppModuleExtension::class.java)
    }

}





