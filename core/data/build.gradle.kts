plugins {
    alias(libs.plugins.runiqueapp.android.library)
    alias(libs.plugins.runiqueapp.jvm.ktor)
}

android {
    namespace = "com.jhebler.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)
}