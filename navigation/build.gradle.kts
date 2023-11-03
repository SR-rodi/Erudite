plugins {
    id(Plugin.library)
    id(Plugin.kotlin)
}

apply<LibrirySettingsGradle>()

android {
    namespace = "ru.sr.erudite.navigation"
}

dependencies {

    compose()
    navigation()
}