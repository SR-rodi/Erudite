plugins {
    id (Plugin.library)
    id (Plugin.kotlin)
}

apply<LibrirySettingsGradle>()

android{
    namespace = "ru.sr.erudite.storage"
}

dependencies{
    compose()
    retroft()
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
}