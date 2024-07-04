plugins {
    alias(libs.plugins.runiqueapp.android.library)
}

android {
    namespace = "com.jhebler.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}