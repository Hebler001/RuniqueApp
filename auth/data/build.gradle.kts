plugins {
    alias(libs.plugins.runiqueapp.android.library)
    alias(libs.plugins.runiqueapp.jvm.ktor)
}

android {
    namespace = "com.jhebler.auth.data"
}

dependencies {
    implementation(libs.bundles.koin)
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.auth.domain)
}