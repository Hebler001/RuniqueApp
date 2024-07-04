plugins {
    alias(libs.plugins.runiqueapp.android.library)
    alias(libs.plugins.runiqueapp.android.room)
}

android {
    namespace = "com.jhebler.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}