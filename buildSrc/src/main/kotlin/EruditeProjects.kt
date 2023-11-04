interface EruditeProjects {
    val name:String

    object UiKit:EruditeProjects{
        override val name: String = ":uiKit"
    }

    object FeatureAuth:EruditeProjects{
        override val name: String = ":feature:auth"
    }
    object Navigation:EruditeProjects{
        override val name: String = ":navigation"
    }
    object Storage:EruditeProjects{
        override val name: String = ":storage"
    }
}