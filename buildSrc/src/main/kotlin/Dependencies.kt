import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementation(dependencies: Any) {
    add("implementation", dependencies)
}

fun DependencyHandler.debugImplementation(dependencies: Any) {
    add("debugImplementation", dependencies)
}

fun DependencyHandler.connect(dependencies: EruditeProjects) {
    implementation(project(dependencies.name))
}

fun DependencyHandler.compose() {
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")

    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")


}

fun DependencyHandler.core() {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
}
fun DependencyHandler.navigation() {
    implementation("androidx.navigation:navigation-compose:2.7.5")
}

fun DependencyHandler.retroft(){
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
}


fun DependencyHandler.okhttpLogging(){
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
}

fun DependencyHandler.di(){
    implementation ("io.insert-koin:koin-android:3.4.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.0")
}

