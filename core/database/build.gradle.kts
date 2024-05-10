plugins {
    alias(libs.plugins.runiqueapp.android.library)
    alias(libs.plugins.runiqueapp.android.room)
}

android {
    namespace = "com.jhebler.core.database"
}

dependencies {
    implementation(projects.core.domain)
}