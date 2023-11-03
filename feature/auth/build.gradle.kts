plugins {
    id (Plugin.library)
    id (Plugin.kotlin)
}

apply<LibrirySettingsGradle>()

android{
    namespace = "ru.sr.erudite.auth"
}

dependencies{
    connect(EruditeProjects.Navigation)

    compose()
    navigation()

}